package com.stunstun.spring.service;

import com.stunstun.spring.domain.User;

/**
 * @author minhyeok
 */
public interface UserService {

    public Iterable<User> findAll();
    public User findOne(Long id);
    public User save(User user);
    public User update(User user);
    public void delete(Long id);
}
