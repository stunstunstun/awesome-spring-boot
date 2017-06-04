package com.stunstun.spring;

import com.stunstun.spring.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
    }

    private final UserService userService;

    public SpringBootJdbcExampleApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(userService.findAll());
    }
}
