package com.jce.mvc.commons.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jce.mvc.commons.annotation.Auth;
import com.jce.mvc.commons.service.AuthContext;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

public class LoginSessionArgumentResolver implements HandlerMethodArgumentResolver {

	private AuthContext authContext;

	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(Auth.class) != null;
	}
	
	public Object resolveArgument(
			MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		HttpServletResponse response = (HttpServletResponse) webRequest.getNativeResponse();
		
		return getAuthContext().getLoginSession(request, response);
	}
	
	public void setAuthContext(AuthContext authContext) {
		this.authContext = authContext;
	}
	
	public AuthContext getAuthContext() {
		return authContext;
	}
}
