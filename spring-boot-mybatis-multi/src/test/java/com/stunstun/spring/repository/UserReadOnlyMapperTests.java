/**
 * 
 */
package com.stunstun.spring.repository;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;
import com.stunstun.spring.repository.entity.User;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class UserReadOnlyMapperTests extends AbstractTestableContext {

	@Autowired
	private UserReadOnlyMapper userReadOnlyMapper;
	
	@Test
	public void selectOne() {
		User entity = userReadOnlyMapper.selectByUserName("stunstun");
		assertThat(entity, nullValue());
	}
}
