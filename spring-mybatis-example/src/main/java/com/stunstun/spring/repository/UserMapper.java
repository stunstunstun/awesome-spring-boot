/**
 * 
 */
package com.stunstun.spring.repository;

import java.util.List;

import com.stunstun.spring.repository.entity.User;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public interface UserMapper {

	public List<User> selectList();
	
	public User selectOne(int userId);
	
	public void update(User user);
	
	public void delete(int userId);
}
