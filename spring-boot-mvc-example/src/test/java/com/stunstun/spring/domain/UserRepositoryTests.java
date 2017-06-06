package com.stunstun.spring.domain;

import com.stunstun.spring.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class UserRepositoryTests extends AbstractIntegrationTest {

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
        users.forEach(user -> {
            assertThat(user.getUserName()).isNotEmpty();
        });
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
