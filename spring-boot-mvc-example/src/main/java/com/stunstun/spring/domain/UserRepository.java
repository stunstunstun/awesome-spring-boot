package com.stunstun.spring.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author minhyeok
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findByUserName(String userName);
}