package com.jce.commons.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author Jung Min Hyuck(chujinnoon@joycity.com)
 * @date 2012. 6. 11.
 * @description Common Exception Resolver, This Class log messages
 */

public class LoggingExceptionResolver extends SimpleMappingExceptionResolver {

private static final Log logger = LogFactory.getLog(LoggingExceptionResolver.class);
	
	protected void logException(Exception e, HttpServletRequest request) {
		if(logger.isErrorEnabled()) {
			logger.error(buildLogMessage(e, request), e);
		}
	}
}
