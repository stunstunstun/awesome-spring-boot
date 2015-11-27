/**
 * 
 */
package com.stunstun.spring.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.stunstun.spring.repository.entity.User;
import com.stunstun.spring.repository.support.Slave;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@Slave
public interface UserReadOnlyMapper {

	public List<User> selectList();
	
	public User selectOne(Long id);
	
	public User selectByUserName(@Param("userName") String userName);
}
