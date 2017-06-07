package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author stunstun
 *
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		List<User> users = userMapper.findAll();
		users.forEach(user -> {
			System.out.println(user);
			assertThat(user.getUserName()).isNotNull();
		});
	}

	@Test
	public void findByUserName() {
		List<User> users = userMapper.findByUserName("stunstunstun");
		users.forEach(user -> {
			System.out.println(user);
			assertThat(user.getUserName()).isNotNull();
		});
	}

	@Test
	public void findOne() {
		User entity = userMapper.findOne(1L);
		assertThat(entity).isNotNull();
	}

	@Test
	public void save() {
		User user = new User("peter");
		userMapper.save(user);

		List<User> users = userMapper.findAll();
		assertThat(users.size()).isEqualTo(2);
	}

	@Test
	public void update() {
		User user = userMapper.findOne(1L);
		user.setUserName("peter");

		userMapper.update(user);
		User updated = userMapper.findOne(user.getId());
		assertThat(updated.getUserName()).isEqualTo("peter");
	}

	@Test
	public void delete() {
		User user = userMapper.findOne(1L);
		userMapper.delete(user);
		assertThat(userMapper.exists(1L)).isFalse();
	}
}