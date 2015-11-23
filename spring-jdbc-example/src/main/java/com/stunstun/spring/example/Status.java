/**
 * 
 */
package com.stunstun.spring.example;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class Status {
	
	private String message;
	
	public Status() {}
	
	public Status(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
