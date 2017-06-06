package com.stunstun.spring;

import com.stunstun.spring.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaExampleApplication.class, args);
	}

	private final UserRepository userRepository;

	public SpringBootJpaExampleApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(userRepository.findByUserName("stunstunstun"));
	}
}
