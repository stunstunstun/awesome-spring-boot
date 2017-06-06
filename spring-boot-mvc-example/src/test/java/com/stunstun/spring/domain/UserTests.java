package com.stunstun.spring.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
@RunWith(SpringRunner.class)
@JsonTest
public class UserTests {

    @Autowired
    private JacksonTester<User> json;

    @Test
    public void serializeJson() throws IOException {
        User user = new User(1L, "stunstunstun");
        assertThat(json.write(user)).isEqualToJson(new ClassPathResource("user.json"));
    }

    @Test
    public void deserializeJson() throws IOException {
        User user = json.readObject(new ClassPathResource("user.json"));
        assertThat(user.getUserName()).isEqualTo("stunstunstun");
    }
 }
