package com.wini.lego.listener;

import com.wini.lego.context.Context;

public abstract class Success {
	public void doing(){
		dooo();
		Context.remove();
	}
	public abstract void dooo();
}
