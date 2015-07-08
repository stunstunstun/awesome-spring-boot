package com.jce.commons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jce.commons.service.AuthContext;

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
		
		HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
		return getAuthContext().getLoginSession(request);
	}
	
	public void setAuthContext(AuthContext authContext) {
		this.authContext = authContext;
	}
	
	public AuthContext getAuthContext() {
		return authContext;
	}
}
