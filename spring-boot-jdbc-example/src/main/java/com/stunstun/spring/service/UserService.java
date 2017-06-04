package com.stunstun.spring.service;

import com.stunstun.spring.service.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findByUserName(String userName);
}
