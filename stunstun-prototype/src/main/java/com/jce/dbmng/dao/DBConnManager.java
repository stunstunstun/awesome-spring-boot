package com.jce.dbmng.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("DBConnManager")
public class DBConnManager {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Log logger = LogFactory.getLog(DBConnManager.class);

	public boolean isDBConn() throws Exception {
		try {
			jdbcTemplate.queryForInt("SELECT 1");
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

}
