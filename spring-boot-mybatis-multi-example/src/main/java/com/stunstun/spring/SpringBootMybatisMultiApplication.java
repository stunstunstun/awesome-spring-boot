package com.stunstun.spring;

import com.stunstun.spring.repository.PaymentMapper;
import com.stunstun.spring.repository.UserMapper;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class SpringBootMybatisMultiApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisMultiApplication.class, args);
    }

    private final UserMapper userMapper;

    private PaymentMapper paymentMapper;

    public SpringBootMybatisMultiApplication(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userMapper.findByUserName("stunstunstun"));
        System.out.println(paymentMapper.findByUserName("stunstunstun"));
    }

    @Autowired
    public void setPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }
}
