
package com.stunstun.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Repository("sampleRepository")
public class SampleRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static int checkCount = 0 ;
	
	@Cacheable("checkcount")
	public int checkDBConn(int num) throws Exception {
		
		checkCount++;
		return jdbcTemplate.queryForInt("SELECT " + num);
	}
	
	public int getCount() throws Exception {
		return checkCount;
	}

}
