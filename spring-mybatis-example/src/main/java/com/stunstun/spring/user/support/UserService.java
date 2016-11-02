/**
 * 
 */
package com.stunstun.spring.user.support;

import java.util.List;

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
		return userMapper.selectList();
	}
	
	public User getUser(Long id) {
		return userMapper.selectOne(id);
	}
	
	public User getUser(String userName) {
		return userMapper.selectByUserName(userName);
	}
	
	public void addUser(User user) {
		userMapper.insert(user);
	}
	
	public void updateUser(User user) {
		userMapper.update(user);
	}
	
	public void deleteUser(User user) {
		userMapper.delete(user);
	}
}
