package com.stunstun.spring.common;

/**
 * @author stunstun
 *
 */
public class ResponseObject implements Response {

	private String message;
	
	public ResponseObject(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}