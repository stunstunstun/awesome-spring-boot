package com.stunstun.spring.mvc.commons.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.stunstun.spring.mvc.commons.service.AuthContext;
import com.stunstun.spring.mvc.commons.session.LoginSession;
import com.stunstun.spring.mvc.commons.session.MakeLoginSessionException;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service("thAuthContext")
public class THAuthContext implements AuthContext {

	public LoginSession getLoginSession(HttpServletRequest request, HttpServletResponse response) throws MakeLoginSessionException, Exception {
		LoginSession loginSession = new LoginSession();
		return loginSession;
	}
}
