package com.stunstun.spring.service;

import com.stunstun.spring.service.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        assertThat(users, notNullValue());
    }

    @Test
    public void findByUserName() {
        User entity = userRepository.findByUserName("stunstunstun");
        assertThat(entity.getUserName(), is("stunstunstun"));
    }
}
