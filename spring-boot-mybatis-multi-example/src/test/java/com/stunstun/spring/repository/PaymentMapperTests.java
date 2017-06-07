package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author minhyeok
 */
@Transactional(transactionManager = "paymentTransactionManager")
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentMapperTests {

    @Autowired
    private PaymentMapper paymentMapper;

    @Test
    public void findAll() {
        List<Transaction> transactions = paymentMapper.findAll();
        transactions.forEach(transaction -> {
            System.out.println(transaction);
            assertThat(transaction.getUserName()).isNotNull();
            assertThat(transaction.getPrice()).isNotEqualTo(0);
        });
    }

    @Test
    public void findByUserName() {
        List<Transaction> transactions = paymentMapper.findByUserName("stunstunstun");
        transactions.forEach(transaction -> {
            System.out.println(transaction);
            assertThat(transaction.getUserName()).isNotNull();
            assertThat(transaction.getPrice()).isNotEqualTo(0);
        });
    }

    @Test
    public void findOne() {
        Transaction transactions = paymentMapper.findOne(1L);
        assertThat(transactions).isNotNull();
    }

    @Test
    public void save() {
        Transaction transaction = new Transaction("peter", 1000);
        paymentMapper.save(transaction);

        List<Transaction> transactions = paymentMapper.findAll();
        assertThat(transactions.size()).isEqualTo(2);
    }

    @Test
    public void update() {
        Transaction transaction = paymentMapper.findOne(1L);
        transaction.setPrice(2000);

        paymentMapper.update(transaction);
        Transaction updated = paymentMapper.findOne(transaction.getId());
        assertThat(updated.getPrice()).isEqualTo(2000);
    }

    @Test
    public void delete() {
        Transaction transaction = paymentMapper.findOne(1L);
        paymentMapper.delete(transaction);
        assertThat(paymentMapper.exists(1L)).isFalse();
    }
}
