package com.stunstun.spring.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> {
            System.out.println(user);
            assertThat(user.getUserName()).isNotEmpty();
        });
    }

    @Test
    public void findOne() {
        User entity = userRepository.findOne(1L);
        assertThat(entity).isNotNull();
    }

    @Test
    public void findByUserName() {
        Iterable<User> users = userRepository.findByUserName("stunstunstun");
        users.forEach(user -> assertThat(user.getUserName()).isNotEmpty());
    }

    @Test
    public void save() {
        User entity = new User("peter");
        entity = userRepository.save(entity);
        assertThat(userRepository.exists(entity.getId())).isTrue();
    }

    @Test
    public void update() {
        User entity = userRepository.findOne(1L);
        entity.setUserName("peter");
        userRepository.save(entity);
        assertThat(userRepository.findByUserName("peter")).isNotNull();
    }

    @Test
    public void delete() {
        userRepository.delete(1L);
        assertThat(userRepository.exists(1L)).isFalse();
    }
}
