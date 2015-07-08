package com.jce.mvc.commons.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jce.mvc.commons.session.LoginSession;
import com.jce.mvc.commons.session.MakeLoginSessionException;

public interface AuthContext {

	abstract LoginSession getLoginSession(HttpServletRequest request, HttpServletResponse response) throws MakeLoginSessionException, Exception;
}
