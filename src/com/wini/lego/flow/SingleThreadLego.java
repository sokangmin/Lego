package com.wini.lego.flow;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.annotations.Debug;
import com.wini.lego.blocks.Block;
import com.wini.lego.blocks.EndBlock;
import com.wini.lego.blocks.StartBlock;
import com.wini.lego.context.Context;
import com.wini.lego.exception.LegoRuntimeException;
import com.wini.lego.messages.Message;


@SuppressWarnings("rawtypes")
@Log4j2
public class SingleThreadLego extends Lego implements Runnable {
	private ArrayList<Class<? extends Block>> oBlocks = new ArrayList<Class<? extends Block>>();
	private final ScheduledExecutorService execMain;
	private final int period;
	private final long initialDelay;
	
	public SingleThreadLego() {
		this(1, TimeUnit.SECONDS);
	}
	
	public SingleThreadLego(int periodSecond, TimeUnit unit) {
		execMain = Executors.newSingleThreadScheduledExecutor();
		this.period = periodSecond;
		this.initialDelay = 0;
	}
	
	public SingleThreadLego(int hourOfDay, int minuteOfHour, int secondOfMinute, int periodSecond, TimeUnit unit) {
		
		execMain = Executors.newSingleThreadScheduledExecutor();
		this.period = periodSecond;
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
	
	public void addBlocks(ArrayList<Class<? extends Block>> blocks) {
		this.oBlocks = blocks;
	}
	
	@Override
	public void start() {
		execMain.scheduleAtFixedRate(this, initialDelay, period, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		log.debug("execMain start time - " + System.currentTimeMillis());
		
		ArrayList<Class<? extends Block>>blocks = (ArrayList<Class<? extends Block>>) oBlocks.clone();
		ArrayBlockingQueue<Message<?>> messageQueue = new ArrayBlockingQueue<Message<?>>(1);
		
		while(!blocks.isEmpty()) {
			try {
				Class<? extends Block> clazz = blocks.get(0);
				Block<?,?> block = (Block<?,?>) clazz.newInstance();
				
				if(!messageQueue.isEmpty()) {
					Message message = messageQueue.take();
					
					if(message.getPayLoad() != null) {
						Field field = Block.class.getDeclaredField("inMessage");
						field.setAccessible(true);
						field.set(block, message);
						
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
				
					
			}/* catch(ClassCastException | InterruptedException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException
					| InstantiationException e){
				logger.error("System critical Exception", e);
				System.exit(1);
			}*/catch(ClassCastException e){
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
				break;
			} catch(Exception e) {				
				log.error(e);
				if(failClazz != null) {
					fail(e);
				}
				Context.remove();
				return;
			} 
		}
		
		if(successClazz != null) {
			success();
		}
		
		Context.remove();
	}
}
