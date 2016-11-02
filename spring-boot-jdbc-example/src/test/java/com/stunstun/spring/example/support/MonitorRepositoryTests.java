/**
 * 
 */
package com.stunstun.spring.example.support;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stunstun.spring.SpringBootJdbcExampleApplication;

/**
 * @author stunstun
 *
 */
@SpringApplicationConfiguration(classes = SpringBootJdbcExampleApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MonitorRepositoryTests {
	
	@Autowired
	private MonitorRepository monitorRepository;
	
	@Test
	public void testSelectStatus() {
		assertThat(monitorRepository.selectStatus(), is("OK"));
	}
}
