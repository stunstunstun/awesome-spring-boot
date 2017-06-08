
package com.stunstun.spring.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stunstun.spring.AbstractTestableContext;
import com.stunstun.spring.repository.entity.User;

/**
 * @author stunstun
 *
 */
public class UserMapperTests extends AbstractTestableContext {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void selectOne() {
		User entity = userMapper.findOne(1L);
		assertThat(entity, notNullValue());
	}

	@Test
	public void selectList() {
		List<User> users = userMapper.findAll();
		assertThat(users, notNullValue());
	}

	@Test
	public void delete() {
		User entity = userMapper.findOne(1L);
		userMapper.delete(entity);
		assertThat(userMapper.exists(1L), is(false));
	}

	@Test
	public void update() {
		User entity = userMapper.findOne(1L);
		entity.setUserName("peter");
		userMapper.update(entity);

		User updated = userMapper.findOne(1L);
		assertThat(updated.getUserName(), is("peter"));
	}
}