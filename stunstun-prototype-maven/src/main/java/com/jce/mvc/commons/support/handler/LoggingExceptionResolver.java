package com.jce.mvc.commons.support.handler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.jce.mvc.commons.service.SiteConstService;

/**
 * @author Jung Min Hyuck(chujinnoon@joycity.com)
 * @date 2012. 6. 11.
 * @description Common Exception handler resolver, This class log messages
 */

public class LoggingExceptionResolver extends SimpleMappingExceptionResolver {

	private static final Log logger = LogFactory.getLog(LoggingExceptionResolver.class);
	private final String AJAX_TYPE = ".json";
	
	public LoggingExceptionResolver() {
		setDefaultErrorView(SiteConstService.getSITECONST_SECURE("DEFAULT_ERROR"));
	}
	
	@Override
	protected void logException(Exception e, HttpServletRequest request) {
		if(logger.isErrorEnabled() && !e.getClass().getName().contains("ClientAbortException")) {
			logger.error(buildLogMessage(e, request) + "| METHOD: " + request.getMethod() + " | URI: " + request.getRequestURI() + 
					" | QueryString: " + request.getQueryString(), e);
			
			/**
			 * log example)
			 * ExceptionType | METHOD:GET| URI:/main.jce | QueryString:userId=xxxx
			 */
		}
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
		
		if(shouldApplyTo(request, handler)) {
	        
			if(logger.isDebugEnabled())
	            logger.debug((new StringBuilder("Resolving eception from handler [")).append(handler).append("]: ").append(e).toString());
	        
	        if(request.getRequestURI().contains(AJAX_TYPE)) {
	        	
	        	String errorMessage = null;
	        	ModelAndView mav = new ModelAndView(SiteConstService.getSITECONST_SECURE("JSON_ERROR"));
        		if(e instanceof CannotGetJdbcConnectionException || e instanceof SQLException) 
        		{
        			errorMessage = "DB Connection error.";        			
        			if(logger.isErrorEnabled() && !e.getClass().getName().contains("ClientAbortException")) {
            			logger.error("Error DetailInfo : METHOD: " + request.getMethod() + "\n| URI: " + request.getRequestURI() + "\n| QueryString: " + request.getQueryString() 
            					+ "\n| IP: " + request.getRemoteAddr() + "\n| errorMessage: ", e);
            		} 
        			
        		}else 
        		{
        			errorMessage = "Unexpected server error.";    	
        			if(logger.isErrorEnabled() && !e.getClass().getName().contains("ClientAbortException")) {
            			logger.error("Error DetailInfo : METHOD: " + request.getMethod() + "\n| URI: " + request.getRequestURI() + "\n| QueryString: " + request.getQueryString() 
            					+ "\n| IP: " + request.getRemoteAddr() + "\n| errorMessage: ", e);
            		}
        		}
        		mav.addObject("errorMessage", errorMessage);
        		return mav;
	        }
	        
	        logException(e, request);
	        prepareResponse(e, response);
	        return doResolveException(request, response, handler, e);
	        
	    } else return null;
		
	}
}
