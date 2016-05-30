package com.wini.lego.flow;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.annotations.Debug;
import com.wini.lego.annotations.ForEach;
import com.wini.lego.blocks.Block;
import com.wini.lego.blocks.EndBlock;
import com.wini.lego.blocks.StartBlock;
import com.wini.lego.context.Context;
import com.wini.lego.exception.LegoRuntimeException;
import com.wini.lego.listener.Fail;
import com.wini.lego.listener.Success;
import com.wini.lego.messages.Message;


@SuppressWarnings("rawtypes")
@Log4j2
public class MultiThreadLego extends Lego implements Runnable {
	
	private final ArrayList<Class<? extends Block>> oBlocks = new ArrayList<Class<? extends Block>>();
	private final ScheduledExecutorService execMain;
	private final ExecutorService execService;
	private final int period;
	private final boolean waitYn;
	private CountDownLatch endGate;
	private String name;
	private final long initialDelay;
	
	/**
	 * ExecutorPool size = 1,
	 * period = 1,
	 * waitYn = true
	 */
	public MultiThreadLego() {
		this(1, 1, true, "");
	}
	
	/**
	 * ExecutorPool size > 0,
	 * period(second) > 0
	 */
	public MultiThreadLego(int nThreads, int periodSecond, boolean waitYn, String name) {
		if(nThreads < 1 || periodSecond < 1) {
			log.error("System critical Exception (IllegalArgumentException) - nThreads:" + nThreads + ", peroid:" + periodSecond);
			System.exit(1);
		}
		
		execMain = Executors.newSingleThreadScheduledExecutor();
		execService = Executors.newFixedThreadPool(nThreads);
		this.period = periodSecond;
		this.waitYn = waitYn;
		this.name = name;
		this.initialDelay = 0;
	}
	
	public MultiThreadLego(int hourOfDay, int minuteOfHour, int secondOfMinute, int nThreads, int periodSecond, boolean waitYn, String name) {
		if(nThreads < 1 || periodSecond < 1) {
			log.error("System critical Exception (IllegalArgumentException) - nThreads:" + nThreads + ", peroid:" + periodSecond);
			System.exit(1);
		}
		
		execMain = Executors.newSingleThreadScheduledExecutor();
		execService = Executors.newFixedThreadPool(nThreads);
		this.period = periodSecond;
		this.waitYn = waitYn;
		this.name = name;
		this.initialDelay = computeNextDelay(hourOfDay, minuteOfHour, secondOfMinute);
	}
	
	private long computeNextDelay(int hourOfDay, int minuteOfHour, int secondOfMinute) {
		DateTime now = DateTime.now();
		
		DateTime nextTime = now.withHourOfDay(hourOfDay).withMinuteOfHour(minuteOfHour).withSecondOfMinute(secondOfMinute);
		
		if(now.compareTo(nextTime) > 0) {
			nextTime = nextTime.plusDays(1);
		}
		
		Duration duration = new Duration(now, nextTime);
		
		
		return duration.getStandardSeconds();
	}
	
	@Override
	public void addBlock(String name, Class<? extends Block> clazz) {
		String mode = System.getProperty("mode");
		
		if(mode != null && mode.equalsIgnoreCase("debug")) {
			oBlocks.add(clazz);
		} else {
			Annotation annotation = clazz.getAnnotation(Debug.class);
			if(!(annotation instanceof Debug))
				oBlocks.add(clazz);
		}
	}
	
	@Override
	public void input(String name, Class<? extends StartBlock> clazz) {
		addBlock(name, clazz);
	}

	@Override
	public void filter(String name, Class<? extends Block> clazz) {
		addBlock(name, clazz);
	}

	@Override
	public void output(String name, Class<? extends EndBlock> clazz) {
		addBlock(name, clazz);
	}
	
	@Override
	public void start() {
		execMain.scheduleAtFixedRate(this, initialDelay, period, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		log.debug(name + ":::::::execMain start time - " + System.currentTimeMillis());
		
		ArrayBlockingQueue<Message<?>> messageQueue = new ArrayBlockingQueue<Message<?>>(1);
		//ArrayList<Future> threadFutures = new ArrayList();
		
		ArrayList<Class<? extends Block>>blocks = (ArrayList<Class<? extends Block>>) oBlocks.clone();
		
		boolean boolForEach = true;
		while(!blocks.isEmpty()) {
			try {
				Class<? extends Block> clazz = blocks.get(0);
				
				
				Block<?,?> block = (Block<?,?>) clazz.newInstance();
				
				if(!messageQueue.isEmpty()) {
					Annotation annotation = clazz.getAnnotation(ForEach.class);
					Message msg = messageQueue.take();
					if(annotation instanceof ForEach && msg.getPayLoad() instanceof List) {
						boolForEach = true;
						List list = (List)msg.getPayLoad();	
						
						if(waitYn)
							endGate = new CountDownLatch(list.size());
						
						for(Object body : list) {
//							threadFutures.add(execService.submit(new Service((ArrayList<Class<? extends Block>>) blocks.clone(), body, msg)));
							execService.submit(new Service((ArrayList<Class<? extends Block>>) blocks.clone(), body, msg, successClazz, failClazz));
						}
						
						if(waitYn)
							endGate.await(); // 모든작업쓰레드가 끝날때까지 대기
						
						blocks.clear();	
						
					} else if (msg.getPayLoad() != null) {
						Field field = Block.class.getDeclaredField("inMessage");
						field.setAccessible(true);
						field.set(block, msg);
						
						messageQueue.put(block.dooo());
						blocks.remove(0);
						
					} else { // 전달된 메시지가 null이면 stop
						blocks.clear();
						log.error("delivery message is null");
						fail(null);
						return;
					}
					
				} else {
					messageQueue.put(block.dooo());
					blocks.remove(0);
				}
				
			} /*catch(ClassCastException | InterruptedException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException
					| InstantiationException e){
				logger.error("System critical Exception", e);
				System.exit(1);
			}*/ catch(ClassCastException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(InterruptedException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(IllegalArgumentException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(IllegalAccessException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(NoSuchFieldException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(InstantiationException e){
				log.error("System critical Exception", e);
				System.exit(1);
			} catch(LegoRuntimeException e) {
				log.warn("LegoRuntimeException -> recover start");
				e.recover();
				return;
			} catch(Exception e) {				
				log.error(e);
				if(failClazz != null) {
					fail(e);
				}
				
				Context.remove();
				return;
			} finally {
				//Context.remove();
			}
		}
		
		
		if(!boolForEach && successClazz != null) {
			success();
		}
		
		boolForEach = false;
		
		Context.remove();
		
		/*if(waitYn) {
			for (Future future : threadFutures) {
				try {
					future.get();
				} catch (InterruptedException e) {
					logger.error("MainThread wait Exception", e);
				} catch (ExecutionException e) {
					logger.error("MainThread wait Exception", e);
				}
			}
		}*/
	}
	
    private class Service implements Runnable {
    	private Object payload;
    	private ArrayList<Class<? extends Block>> blocks;
    	private Message msg;
    	private Class<? extends Success> successClazz;
    	private Class<? extends Fail> failClazz;
		Service(ArrayList<Class<? extends Block>> blocks, Object payload, Message msg, Class<? extends Success> successClazz, Class<? extends Fail> failClazz) {
			this.blocks = blocks;
			this.payload = payload;
			this.msg = msg;
			this.successClazz = successClazz;
			this.failClazz = failClazz;
		}
    	
		@SuppressWarnings("unchecked")
		@Override
		public void run() {		
			try {
				ArrayBlockingQueue<Message<?>> queue = new ArrayBlockingQueue<Message<?>>(1);
				Message<Object> m1 = new Message<Object>();
				m1.setPayLoad(payload);
				m1.setHeaders(msg.getHeaders());
				queue.put(m1);
				
				ArrayList bricksClone = (ArrayList) blocks.clone();
	
				DefaultLego flow = new DefaultLego();
				
				Field f1 = DefaultLego.class.getDeclaredField("messageQueue");
				f1.setAccessible(true);
				f1.set(flow, queue);
	
				flow.addBlocks(bricksClone);
				flow.successListener(successClazz);
				flow.failListener(failClazz);
				flow.start();
				
				blocks.clear();
			} /*catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | InterruptedException e) {
				logger.error("System critical Exception", e);
				System.exit(1);
			} */catch (IllegalArgumentException e) {
				log.error("System critical Exception", e);
				System.exit(1);
			} catch (IllegalAccessException e) {
				log.error("System critical Exception", e);
				System.exit(1);
			} catch (NoSuchFieldException e) {
				log.error("System critical Exception", e);
				System.exit(1);
			} catch (SecurityException e) {
				log.error("System critical Exception", e);
				System.exit(1);
			} catch (InterruptedException e) {
				log.error("System critical Exception", e);
				System.exit(1);
			} 
			finally {
				if(waitYn)
					endGate.countDown();
			}
			
			Context.remove();
		}
		
    }
}

