package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUserName(String userName);
}
