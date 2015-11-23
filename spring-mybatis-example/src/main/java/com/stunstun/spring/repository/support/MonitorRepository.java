/**
 * 
 */
package com.stunstun.spring.repository.support;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.stunstun.spring.repository.MonitorMapper;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@Repository
public class MonitorRepository extends SqlSessionDaoSupport implements MonitorMapper {

	@Override
	public String selectStatus() {
		return (String) getSqlSession().selectOne("com.stunstun.spring.repository.MonitorMapper.selectStatus");
	}
}
