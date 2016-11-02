/**
 * 
 */
package com.stunstun.spring.example;

/**
 * @author stunstun
 *
 */
public class Status {
	
	private boolean enable;
	
	public Status() {}

	public Status(boolean enable) {
		this.enable = enable;
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
