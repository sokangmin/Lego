package com.wini.lego.messages;
import java.util.HashMap;


public class Message<T> {
	private T body;
	private HashMap<String, Object> headers = new HashMap<String, Object>();

	public T getPayLoad() {
		return body;
	}

	public void setPayLoad(T body) {
		this.body = body;
	}

	public HashMap<String, Object> getHeaders() {
		return headers;
	}
	
	public void setHeaders(HashMap<String, Object> headers) {
		this.headers = headers;	
	}
	
	public FileType getFileType() {
		return (FileType) headers.get("fileType");
	}
	
	public void setFileType(FileType filetype) {
		headers.put("fileType", filetype);
	}
	
	public Object getMessageId() {
		return headers.get("messageId");
	}
	
	public void setMessageId(String id) {
		headers.put("messageId", id);
	}
	
	public enum FileType {
		JSON,
		XML,
		Object,
		String,
		Integer,
		Empty
	}
}
