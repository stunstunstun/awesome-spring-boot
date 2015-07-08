/**
 * @file MainDao.java
 * @brief MainDao Source file
 */
/**
 *
 */

/**
 * @brief com.jce.api.social.dao
 */
package com.jce.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MainDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int checkDBConn() throws Exception {
		return jdbcTemplate.queryForInt("SELECT 1");
	}

}
