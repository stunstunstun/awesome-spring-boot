/**
 * 
 */
package com.stunstun.spring.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
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
	
	private User entity;
	
	@Before
	public void setUp() {
		entity = new User();
		entity.setUserName("stunstun");
		entity.setPassword("stunstun");
		
		userMapper.insert(entity);
		entity = userMapper.selectByUserName("stunstun");
	}
	
	@Test
	public void insertAndDelete() {
		assertThat(entity, notNullValue());
		
		User user = userMapper.selectByUserName("stunstun");
		userMapper.delete(user);
	
		user = userMapper.selectByUserName("stunstun");
		assertThat(user, nullValue());
	}
	
	@Test
	public void updateAndSelectByUserName() {
		assertThat(entity, notNullValue());
		
		User user = userMapper.selectByUserName("stunstun");
		user.setUserName("stunstunstun");
		
		userMapper.update(user);
		
		User updatedUser = userMapper.selectByUserName("stunstunstun");
		assertThat(user.getId(), is(updatedUser.getId()));
	}
	
	@Test
	public void selectList() {
		List<User> users = userMapper.selectList();
		assertThat(users, notNullValue());
	}
	
	@Test
	public void selectOne() {
		assertThat(entity, notNullValue());
		
		User user = userMapper.selectOne(entity.getId());
		assertThat(user, notNullValue());
	}
}