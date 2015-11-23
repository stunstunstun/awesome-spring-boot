/**
 * 
 */
package com.stunstun.spring.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
		assertThat(monitorService.isEnable(), is(true));
	}
}
