package com.stunstun.spring.example.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author stunstun
 *
 */
@Repository
public class MonitorRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MonitorRepository.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String selectStatus() {
		String result = jdbcTemplate.queryForObject("SELECT 'OK'", new Object[] {}, String.class);
		LOGGER.info("selectStatus = {}", result);
		return result;
	}
}
