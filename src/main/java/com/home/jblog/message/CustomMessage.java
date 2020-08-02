package com.home.jblog.message;

import java.util.Map;

import lombok.Data;

@Data
public class CustomMessage{
	
	private String code;
	private String message;
	private Object data;
	
	
	public CustomMessage() {
		
	}
	
	public CustomMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public CustomMessage(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
}