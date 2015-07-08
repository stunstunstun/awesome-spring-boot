package com.jce.mvc.commons.session;

import java.util.StringTokenizer;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */
public class LoginSession {
	
	protected String sessionGUID;			// SessionGUID
	protected int userIdIndex = -1;			// UserIDIndex
	protected String userId;				// UserID
	protected String email;					// Email
	protected int cash;						// Cash
	protected String sex;					// sex
	protected boolean login = false;		// login status
	
	/**
	 * Cash info ( Only Jocity )
	 */
	
	public int getUserCash(String cashInfo, int siteCode) {
		
		if(cashInfo == null || cashInfo.equals("") ) return 0;
		int cash = 0;
		StringTokenizer records = new StringTokenizer(cashInfo, "|");
		int chargeCash = Integer.parseInt(records.nextToken());
		
		while(records.hasMoreTokens()) {
			String[] eventcash = records.nextToken().split(":");
			if(siteCode == Integer.parseInt(eventcash[0])) {
				cash = Integer.parseInt(eventcash[1]);
				break;
			}
		}
		
		return chargeCash + cash;
	}

	public String getSessionGUID() {
		return sessionGUID;
	}

	public void setSessionGUID(String sessionGUID) {
		this.sessionGUID = sessionGUID;
	}

	public int getUserIdIndex() {
		return userIdIndex;
	}

	public void setUserIdIndex(int userIdIndex) {
		this.userIdIndex = userIdIndex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	
}