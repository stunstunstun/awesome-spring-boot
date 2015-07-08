package com.jce.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static final Log logger = LogFactory.getLog(RequestInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// Before controller
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception {
		
	}
	
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception e) throws Exception {
		if(e != null && logger.isErrorEnabled()) logger.error("Error has been catched at afterCompletion(In action Class):", e);
	}
}
