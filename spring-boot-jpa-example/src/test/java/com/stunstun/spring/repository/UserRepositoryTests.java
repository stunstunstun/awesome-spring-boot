package com.stunstun.spring.repository;

import com.stunstun.spring.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    public static final String USER_NAME = "stunstunstun";

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        Iterator<User> iterator = userRepository.findAll().iterator();
        assertThat(iterator, notNullValue());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void findByUserName() {
        List<User> entities = userRepository.findByUserName(USER_NAME);
        assertThat(entities, notNullValue());
    }

    @Test
    public void findOne() {
        User entity = userRepository.findOne(1L);
        assertThat(entity, notNullValue());
    }

    @Test
    public void save() {
        User user = new User("peter");
        userRepository.save(user);
        assertThat(userRepository.count(), is(2));
    }

    @Test
    public void update() {
        User entity = userRepository.findOne(1L);
        entity.setUserName("peter");

        userRepository.save(entity);
        User updated = userRepository.findOne(entity.getId());
        assertThat(updated.getUserName(), is("peter"));
    }

    @Test
    public void delete() {
        userRepository.delete(1L);
        assertThat(userRepository.exists(1L), is(false));
    }
}
