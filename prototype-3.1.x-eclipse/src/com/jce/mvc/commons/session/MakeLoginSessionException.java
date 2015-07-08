package com.jce.mvc.commons.session;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */
public class MakeLoginSessionException extends Exception {

	private static final long serialVersionUID = -2294424124441917675L;

	public MakeLoginSessionException(String message) {
		super(message);
	}
	
	public MakeLoginSessionException(String message, Exception e) {
		super(message, e);
	}
}
