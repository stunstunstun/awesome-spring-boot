package com.stunstun.spring.repository;

import com.stunstun.spring.SpringBootMybatisExampleApplication;
import com.stunstun.spring.repository.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author stunstun
 *
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMybatisExampleApplication.class)
public class UserMapperTests {
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