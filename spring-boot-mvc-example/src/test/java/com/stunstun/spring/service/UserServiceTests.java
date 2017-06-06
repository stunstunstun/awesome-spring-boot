package com.stunstun.spring.service;

import com.stunstun.spring.AbstractIntegrationTest;
import com.stunstun.spring.ResourceNotFoundException;
import com.stunstun.spring.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
public class UserServiceTests extends AbstractIntegrationTest {

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
