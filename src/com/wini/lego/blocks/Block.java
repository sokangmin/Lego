package com.wini.lego.blocks;

import java.util.HashMap;

import com.wini.lego.messages.Message;
import com.wini.lego.messages.Message.FileType;


public abstract class Block<IN, OUT> {
	private Message<IN> inMessage;
	private Message<OUT> outMessage = new Message<OUT>();
	
	abstract protected OUT doing(IN data);
	
	public FileType getMsgFileType() {
		return inMessage == null ? FileType.Empty : inMessage.getFileType();
	}
	
	public void setMsgFileType(FileType fileType) {
		outMessage.setFileType(fileType);
	}
	
	public String getMessageId() {
		
		return inMessage == null ? "" : inMessage.getMessageId().toString();
	}
	
	public Message<OUT> dooo() throws ClassCastException {
		OUT result;
		HashMap<String, Object> messageHeaders;
		String messageId;
		
		if(inMessage != null) {
			messageHeaders = inMessage.getHeaders();
			outMessage.setHeaders(messageHeaders);
			result = doing(inMessage.getPayLoad());	
		} else {
			result = doing(null);
			messageId = String.valueOf(System.currentTimeMillis());
			outMessage.setMessageId(messageId);
		}
		
		
		outMessage.setPayLoad(result);
				
		return outMessage;
	}
}
