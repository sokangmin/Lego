package com.wini.lego.flow;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

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
public class DefaultLego extends Lego {
	private List<Class<? extends Block>> blocks = new ArrayList<Class<? extends Block>>();
	private ArrayBlockingQueue<Message<?>> messageQueue = new ArrayBlockingQueue<Message<?>>(1);
	
	@Override
	public void addBlock(String name, Class<? extends Block> clazz) {
		String mode = System.getProperty("mode");
		
		if(mode != null && mode.equalsIgnoreCase("debug")) {
			blocks.add(clazz);
		} else {
			Annotation annotation = clazz.getAnnotation(Debug.class);
			if(!(annotation instanceof Debug))
				blocks.add(clazz);
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
	
	void addBlocks(List<Class<? extends Block>> blocks) {
		this.blocks = blocks;
	}
	
	@Override
	public void start() {
		
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
				
					
			} catch(ClassCastException e){
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
			}
			
			
			catch(LegoRuntimeException e) {
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
			} 
		}
		
		if(successClazz != null) {
			success();		
		}
		Context.remove();
	}
}
