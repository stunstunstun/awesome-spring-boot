package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author stunstun
 *
 */
public interface UserMapper {

	public List<User> findAll();

	public Boolean exists(Long id);

	public User findOne(Long id);
	
	public User findByUserName(@Param("userName") String userName);
	
	public void save(User user);
	
	public void update(User user);

	public void delete(User user);
}
