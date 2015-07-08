package com.jce.mvc.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jce.mvc.commons.interceptor.support.TrafficManager;
import com.jce.mvc.commons.service.SiteConstService;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

public class RequestInterceptor extends HandlerInterceptorAdapter {

	private boolean disableCaching;
	private final String AJAX_TYPE = ".json";
	private static final Log logger = LogFactory.getLog(RequestInterceptor.class);
	
	public RequestInterceptor() {
		disableCaching = true;
	}
	
	// Before controller
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// Traffic check		
		boolean isOverTraffic = TrafficManager.getInstance().checkTraffic(
				request, 
				Integer.parseInt(SiteConstService.getSITECONST_SECURE("TRAFFIC_COUNT")), 
				Integer.parseInt(SiteConstService.getSITECONST_SECURE("TRAFFIC_QUEUE_SIZE"))
				);
		
		if(isOverTraffic) {
			
			logger.warn("RequestInterceptor: be aware of over traffic of request, IP: " + request.getRemoteAddr() + ", URI: " + request.getRequestURI());
			
			if(request.getRequestURI().contains(AJAX_TYPE)) 
			{
				throw new ModelAndViewDefiningException(new ModelAndView(SiteConstService.getSITECONST_SECURE("JSON_ERROR"))
				.addObject("errorMessage", "be aware of over traffic of request"));
			}
			
			throw new ModelAndViewDefiningException(new ModelAndView(SiteConstService.getSITECONST_SECURE("TRAFFIC_PAGE")));
		}
		
		return true;
	}
	
	// After controller
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView model) throws Exception {
		
		if(disableCaching) {
			response.addHeader("Pragma", "no-cache");
			response.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
			response.addDateHeader("Expires", 1L);
		}
	}
	
	// Before view-layer
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		
		if(e != null && logger.isErrorEnabled() && !e.getClass().getName().contains("ClientAbortException")) {
			logger.error("Error afterCompletion | " + e + " | METHOD: " + request.getMethod() + " | URI: " + request.getRequestURI() + 
					" | QueryString: " + request.getQueryString());
		}
	}
}
