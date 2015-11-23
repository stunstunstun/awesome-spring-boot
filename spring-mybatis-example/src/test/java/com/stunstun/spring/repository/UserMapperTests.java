/**
 * 
 */
package com.stunstun.spring.repository;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;
import com.stunstun.spring.repository.entity.User;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class UserMapperTests extends AbstractTestableContext {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTests.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void selectOne() {
		User userEntity = userMapper.selectOne(1000001);
		LOGGER.info("userEntity = {}", userEntity);
		assertThat(userEntity, notNullValue());
	}
}
