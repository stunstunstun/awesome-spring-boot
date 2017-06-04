package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author stunstun
 *
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

	public static final String USER_NAME = "stunstunstun";

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		List<User> users = userMapper.findAll();
		assertThat(users, notNullValue());
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void findByUserName() {
		User entity = userMapper.findByUserName(USER_NAME);
		assertThat(entity, notNullValue());
	}

	@Test
	public void findOne() {
		User entity = userMapper.findOne(1L);
		assertThat(entity, notNullValue());
	}

	@Test
	public void save() {
		User user = new User("peter");
		userMapper.save(user);

		List<User> users = userMapper.findAll();
		assertThat(users.size(), is(2));
	}

	@Test
	public void update() {
		User user = userMapper.findOne(1L);
		user.setUserName("peter");

		userMapper.update(user);
		User updated = userMapper.findOne(user.getId());
		assertThat(updated.getUserName(), is("peter"));
	}

	@Test
	public void delete() {
		User user = userMapper.findOne(1L);
		userMapper.delete(user);
		assertThat(userMapper.exists(1L), is(false));
	}
}