
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
	public static final String ENTITY_NAME = "stunstunstun";

	@Autowired
	private UserMapper userMapper;
	private User entity;

	@Test
	public void selectOne() {
		User user = userMapper.selectOne(1L);
		assertThat(user, notNullValue());
	}

	@Test
	public void selectList() {
		List<User> users = userMapper.selectList();
		assertThat(users, notNullValue());
	}

	@Test
	public void delete() {
		User user = userMapper.selectByUserName(ENTITY_NAME);
		userMapper.delete(user);

		user = userMapper.selectByUserName(ENTITY_NAME);
		assertThat(user, nullValue());
	}

	@Test
	public void update() {
		User user = userMapper.selectByUserName(ENTITY_NAME);
		user.setUserName("peter");

		userMapper.update(user);

		User updatedUser = userMapper.selectByUserName("peter");
		assertThat(user.getId(), is(updatedUser.getId()));
	}
}