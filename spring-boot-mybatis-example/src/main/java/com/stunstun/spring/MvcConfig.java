/**
 * 
 */
package com.stunstun.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@Configuration
public class MvcConfig {
	
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
}
