package com.wini.lego.listener;

import com.wini.lego.context.Context;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class Fail {
	protected Exception exception = null;
	
	public void doing() {
		log.error(">>>Fail>>>Fail>>>Fail>>>Fail>>>Fail>>>Fail>>>Fail>>>Fail>>>");
		dooo();
		Context.remove();
		log.error("<<<Fail<<<Fail<<<Fail<<<Fail<<<Fail<<<Fail<<<Fail<<<Fail<<<");
	}
	
	public abstract void dooo();
}
