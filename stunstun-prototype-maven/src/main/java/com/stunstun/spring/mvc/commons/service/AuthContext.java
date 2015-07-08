package com.stunstun.spring.mvc.commons.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stunstun.spring.mvc.commons.session.LoginSession;
import com.stunstun.spring.mvc.commons.session.MakeLoginSessionException;

public interface AuthContext {

	abstract LoginSession getLoginSession(HttpServletRequest request, HttpServletResponse response) throws MakeLoginSessionException, Exception;
}
