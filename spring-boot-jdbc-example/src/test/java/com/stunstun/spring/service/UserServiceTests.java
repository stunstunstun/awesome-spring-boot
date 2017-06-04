package com.stunstun.spring.service;

import com.stunstun.spring.service.entity.User;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void findByUserName() {
        User user = userService.findByUserName("stunstunstun");
        Assert.assertThat(user.getId(), CoreMatchers.is(1L));
    }
}
