package com.jce.mvc.commons.support.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * <PRE>
 * Class/Interface Name : LoggingAdvice
 * History
 *     1. RyuHa(riverha@joycity.com), 2009. 9. 28., 최초작성
 * </PRE>
 * @brief 
 * @date 2009. 9. 28.
 * @version 1.0.0
 * @author RyuHa(riverha@joycity.com)
 * @warning 
 */
public class LoggingAdvice {
	
	private static final Log logger = LogFactory.getLog(LoggingAdvice.class);

	public Object logOperations(ProceedingJoinPoint pjp) throws Throwable {
		String targetClassName = pjp.getTarget().getClass().getName();
		String targetMethodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		if (logger.isDebugEnabled()) {
			logger.debug(" [ Start("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
			for (int i = 0; i < args.length; i++) {
				logger.debug("arguments[" + i + "] : " + args[i]);
			}
		}
		
		Object returnValue = pjp.proceed();
		
		if (logger.isDebugEnabled()) {
			logger.debug(" [ End("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
		}
		
		return returnValue;
	}

	public void logException(JoinPoint pjp, Exception exception) throws Exception {
		String targetClassName = pjp.getTarget().getClass().getName();
		String targetMethodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		
		if (logger.isWarnEnabled()) {
			logger.warn(" [ Start("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
			for (int i = 0; i < args.length; i++) {
				logger.warn("arguments[" + i + "] : " + args[i]);
			}
			logger.warn("[ Exception Message ]" , exception);
		} else if (logger.isErrorEnabled()) {
			logger.error(" [ Start("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
			for (int i = 0; i < args.length; i++) {
				logger.error("arguments[" + i + "] : " + args[i]);
			}
			logger.error("[ Exception Message ]" , exception);
		}
		
		if (logger.isWarnEnabled()) {
			logger.warn(" [ End("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
		} else if (logger.isErrorEnabled()) {
			logger.error(" [ End("+getDateTime()+") ] " + targetClassName + "." + targetMethodName);
		}
	}
	
	private String getDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA); 
		Date currentTime = new Date();                                 
		String result = formatter.format(currentTime);                  
		return result;
	}
}