/**
 * 
 */
package com.stunstun.spring.common;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class ResponseHttpStatus {
	
	@JsonIgnore
	protected int httpStatus;
	protected String message;
	
	public ResponseHttpStatus() {}
	
	public ResponseHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus.value();
		this.message = httpStatus.getReasonPhrase();
	}
	
	public ResponseHttpStatus(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus.value();
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}