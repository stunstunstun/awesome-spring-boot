package com.stunstun.spring.domain;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * @author minhyeok
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private Iterable<User> users;

    @Before
    public void setup() {
        User user1 = new User(1L, "stunstunstun1", "backend");
        User user2 = new User(5L, "stunstunstun5", "backend");
        User user3 = new User(4L, "stunstunstun4", "frontend");
        User user4 = new User(2L, "stunstunstun2", "backend");
        User user5 = new User(3L, "stunstunstun3", "frontend");

        users = Lists.newArrayList(user1, user2, user3, user4, user5);
    }

    @Test
    public void stringObject() {
        List<String> messages = Arrays.asList("A", "B", "C", "D", "E");
        for (int i = 0; i < messages.size(); i++) {
            String message = messages.get(i);
            System.out.println(String.format("%s@%d", message, message.hashCode()));
            message = message + i;
            System.out.println(String.format("%s@%d", message, message.hashCode()));
            messages.set(i, message);
        }
        assertThat(messages.contains("A0")).isTrue();
        assertThat(messages.contains("B1")).isTrue();
        assertThat(messages.contains("C2")).isTrue();
        assertThat(messages.contains("D3")).isTrue();
        assertThat(messages.contains("E4")).isTrue();
        assertThat(messages.size()).isEqualTo(5);
    }

    @Test
    public void immutableObject() {
        String caption = "caption";
        String content = "content";
        String other = "content";
        assertThat(caption.hashCode()).isNotEqualTo(content.hashCode());
        assertThat(content.hashCode()).isEqualTo(other.hashCode());

        User user = new User(1L, "stunstunstun", "");
        User user2 = new User(2L, "jung", "");
        User otherUser = new User(2L, "jung", "");
        assertThat(user.hashCode()).isNotEqualTo(user2.hashCode());
        assertThat(user2).isEqualTo(otherUser);
        assertThat(user2.hashCode()).isEqualTo(otherUser.hashCode());

        otherUser.setUserName("jungminhyeok");
        assertThat(user2).isNotEqualTo(otherUser);
    }

    @Test
    public void immutableObjectByList() {
        given(userRepository.findAll()).willReturn(users);

        List<User> users = userService.findAll();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user);
            user.setUserName(user.getUserName().replaceAll("stunstunstun", "stun"));
            System.out.println(user);
        }
        assertThat(users.get(0).getUserName()).isEqualTo("stun1");
    }

    @Test
    public void findUsersByKeys() {
        given(userRepository.findAll()).willReturn(users);

        List<User> users = userService.findUsersByKeys(2L, 4L);
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void findKeysByField() {
        given(userRepository.findAll()).willReturn(users);

        List<Long> keys = userService.findKeysByField("backend");
        assertThat(keys.size()).isEqualTo(3);
        assertThat(keys.get(0)).isEqualTo(1L);
    }

    @Test
    public void findUserNamesByField() {
        given(userRepository.findAll()).willReturn(users);

        List<String> names = userService.findUserNamesByField("frontend");
        assertThat(names.size()).isEqualTo(2);
    }
}
