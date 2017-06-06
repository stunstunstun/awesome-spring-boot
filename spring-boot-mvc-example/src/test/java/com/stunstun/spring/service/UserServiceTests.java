package com.stunstun.spring.service;

import com.stunstun.spring.ResourceNotFoundException;
import com.stunstun.spring.domain.User;
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
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void update() {
        User user = userService.findOne(1L);
        user.setUserName("peter");

        User updated = userService.update(user);
        assertThat(updated.getUserName()).isEqualTo("peter");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateAndResourceNotFoundException() {
        User user = new User(2L, "peter");
        userService.update(user);
    }

    @Test
    public void delete() {
        User user = userService.findOne(1L);
        userService.delete(user.getId());
        assertThat(userService.findOne(user.getId())).isNull();
    }
}
