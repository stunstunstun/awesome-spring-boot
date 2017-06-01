
package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stunstun
 *
 */
public interface UserMapper {

	public List<User> selectList();
	
	public User selectOne(Long id);
	
	public User selectByUserName(@Param("userName") String userName);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(User user);
}
