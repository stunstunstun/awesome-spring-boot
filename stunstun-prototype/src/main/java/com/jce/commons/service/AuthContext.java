package com.jce.commons.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.jce.commons.session.LoginSession;
import com.jce.commons.session.MakeLoginSessionException;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service
public class AuthContext {

	public LoginSession getLoginSession(HttpServletRequest request) throws MakeLoginSessionException, Exception {
		LoginSession loginSession = new LoginSession();
		return loginSession;
	}
}
