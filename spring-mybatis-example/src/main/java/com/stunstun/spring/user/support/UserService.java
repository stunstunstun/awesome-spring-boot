package com.stunstun.spring.user.support;

import java.util.List;

import com.stunstun.spring.common.support.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stunstun.spring.repository.UserMapper;
import com.stunstun.spring.repository.entity.User;

/**
 * @author stunstun
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUsers() {
		return userMapper.findAll();
	}
	
	public User getUser(Long id) {
		User entity = userMapper.findOne(id);
		if (entity == null)
			throw new ResourceNotFoundException();
		return entity;
	}
	
	public List<User> getUser(String userName) {
		return userMapper.findByUserName(userName);
	}
	
	public void addUser(User user) {
		userMapper.save(user);
	}
	
	public void updateUser(User user) {
		userMapper.update(user);
	}
	
	public void deleteUser(Long id) {
		User entity = this.getUser(id);
		if (entity == null) {
			throw new ResourceNotFoundException();
		}
		userMapper.delete(entity);
	}
}
