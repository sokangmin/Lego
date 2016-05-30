package com.wini.lego.exception;

public abstract class LegoRuntimeException extends RuntimeException{
	
	private static final long serialVersionUID = 3588374332461421726L;
	protected Object inputData;
	
	public LegoRuntimeException(Throwable cause, Object inputData) {
		super(cause);
		this.inputData = inputData;
	}
	
	abstract public void recover();
}
