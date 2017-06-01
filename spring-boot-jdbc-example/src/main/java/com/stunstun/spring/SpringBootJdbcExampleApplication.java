package com.stunstun.spring;

import com.stunstun.spring.example.support.MonitorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
    }

    private final MonitorRepository monitorRepository;

    public SpringBootJdbcExampleApplication(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(monitorRepository.selectStatus());
    }
}
