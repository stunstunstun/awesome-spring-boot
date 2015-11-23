/**
 * 
 */
package com.stunstun.spring.repository.entity;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class User {

	private int userId;
	
	private String userName;
	
	private String token;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other != null && other instanceof User) {
			if (((User) other).getUserId() == this.userId) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (userName == null ? userName.length() : 0);
	}
	
	@Override
	public String toString() {
		return "userId[" + userId +"] userName[" + userName + "]";
	}
}
