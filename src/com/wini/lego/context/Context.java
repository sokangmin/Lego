package com.wini.lego.context;

public class Context {
	private static ThreadLocal<Object> local = new ThreadLocal<Object>();
	
	public static Object get() {
		return local.get();
	}
	
	public static void set(Object obj) {
		local.set(obj);
	}
	
	public static void remove() {
		local.remove();
	}
}
