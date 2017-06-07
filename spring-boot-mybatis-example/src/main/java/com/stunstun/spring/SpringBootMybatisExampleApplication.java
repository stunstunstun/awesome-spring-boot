package com.stunstun.spring;

import com.stunstun.spring.repository.UserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMybatisExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisExampleApplication.class, args);
    }

    private final UserMapper userMapper;

    public SpringBootMybatisExampleApplication(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userMapper.findByUserName("stunstunstun"));
    }
}
