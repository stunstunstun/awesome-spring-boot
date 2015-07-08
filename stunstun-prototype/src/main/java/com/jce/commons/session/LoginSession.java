package com.jce.commons.session;

import java.io.Serializable;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */
public class LoginSession implements Serializable {
	private static final long serialVersionUID = -7733355265454266564L;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isLogin() {
		return (userId != null);
	}
}