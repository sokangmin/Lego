package com.wini.lego.flow;

import java.lang.reflect.Field;

import lombok.extern.log4j.Log4j2;

import com.wini.lego.blocks.Block;
import com.wini.lego.blocks.EndBlock;
import com.wini.lego.blocks.StartBlock;
import com.wini.lego.listener.Fail;
import com.wini.lego.listener.Success;


@SuppressWarnings("rawtypes")
@Log4j2
public abstract class Lego {
	@Deprecated
	public abstract void addBlock(String name, Class<? extends Block> clazz);
	public abstract void input(String name, Class<? extends StartBlock> clazz);
	public abstract void filter(String name, Class<? extends Block> clazz);
	public abstract void output(String name, Class<? extends EndBlock> clazz);
	public abstract void start();
	
	protected Class<? extends Success> successClazz = null;
	protected Class<? extends Fail> failClazz = null;
	
	public void successListener(Class<? extends Success> clazz) {
		successClazz = clazz;
	}

	public void failListener(Class<? extends Fail> clazz) {
		failClazz = clazz;
	}
	
	protected void fail(Exception e) {
		try {
			Fail fail = failClazz.newInstance();
			Field field = Fail.class.getDeclaredField("exception");
			field.setAccessible(true);
			field.set(fail, e);
			
			fail.doing();
		} catch (InstantiationException e1) {
			log.error("System critical Exception", e1);
			System.exit(1);
		} catch (IllegalAccessException e1) {
			log.error("System critical Exception", e1);
			System.exit(1);
		} catch (NoSuchFieldException e1) {
			log.error("System critical Exception", e1);
			System.exit(1);
		} catch (SecurityException e1) {
			log.error("System critical Exception", e1);
			System.exit(1);
		}
	}
	
	protected void success() {
		try {
			Success success = successClazz.newInstance();
			success.doing();
		} catch (InstantiationException e) {
			log.error("System critical Exception", e);
			System.exit(1);
		} catch (IllegalAccessException e) {
			log.error("System critical Exception", e);
			System.exit(1);
		}
	}
}
