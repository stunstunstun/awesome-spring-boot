/**
 * 
 */
package com.stunstun.spring.repository.support;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class MonitorRepositoryTests extends AbstractTestableContext {

	@Autowired
	private MonitorRepository monitorRepository;
	
	@Test
	public void testSelectStatus() {
		assertThat(monitorRepository.selectStatus(), is("OK"));
	}
}
