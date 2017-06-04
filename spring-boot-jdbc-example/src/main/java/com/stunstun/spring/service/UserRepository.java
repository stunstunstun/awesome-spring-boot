package com.stunstun.spring.service;

import com.stunstun.spring.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author stunstun
 *
 */
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT user.id, user.user_name");
        query.append(" FROM user");
        return jdbcTemplate.query(query.toString(), (rs, rowNum) -> {
            User entity = new User(rs.getLong("id"), rs.getString("user_name"));
            return entity;
        });
    }

    public User findByUserName(String userName) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT user.id, user.user_name");
        query.append(" FROM user");
        query.append(" WHERE user.user_name = ?");
        return jdbcTemplate.queryForObject(query.toString(), new Object[]{userName}, (rs, rowNum) -> {
            User entity = new User(rs.getLong("id"), rs.getString("user_name"));
            return entity;
        });
    }
}
