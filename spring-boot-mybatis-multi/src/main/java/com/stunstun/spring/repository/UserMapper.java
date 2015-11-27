/**
 * 
 */
package com.stunstun.spring.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stunstun.spring.repository.entity.User;
import com.stunstun.spring.repository.support.Master;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@Master
public interface UserMapper {

	public List<User> selectList();
	
	public User selectOne(Long id);
	
	public User selectByUserName(@Param("userName") String userName);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(User user);
}
