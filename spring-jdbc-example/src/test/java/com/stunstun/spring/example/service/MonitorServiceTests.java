/**
 * 
 */
package com.stunstun.spring.example.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;
import com.stunstun.spring.example.support.MonitorService;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class MonitorServiceTests extends AbstractTestableContext {

	@Autowired
	private MonitorService monitorService;
	
	@Test
	public void testHealthCheckDataSource() {
		monitorService.checkDataSource();
	}
}
