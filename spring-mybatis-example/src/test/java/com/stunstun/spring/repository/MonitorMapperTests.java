/**
 * 
 */
package com.stunstun.spring.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class MonitorMapperTests extends AbstractTestableContext {
	
	@Autowired
	private MonitorMapper monitorMapper;
	
	@Test
	public void testSelectStatus() {
		assertThat(monitorMapper.selectStatus(), is("OK"));
	}
}
