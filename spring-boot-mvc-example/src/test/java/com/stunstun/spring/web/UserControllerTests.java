package com.stunstun.spring.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stunstun.spring.domain.User;
import com.stunstun.spring.service.UserService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author minhyeok
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<User> json;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void list() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.findAll()).willReturn(Lists.newArrayList(user));

        mvc.perform(get("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(user.getId().intValue())))
                .andExpect(jsonPath("$[0].userName", is(user.getUserName())));
    }

    @Test
    public void save() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.save(user)).willReturn(user);

        mvc.perform(post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.write(user).getJson()))
                .andExpect(status().isOk());
    }

    @Test
    public void saveAndUnsupportedMediaType() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.save(user)).willReturn(user);

        mvc.perform(post("/users")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void saveAndRequestBodyNotReadable() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.save(user)).willReturn(user);

        mvc.perform(post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void findOne() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.findOne(user.getId())).willReturn(user);

        mvc.perform(get("/users/{id}", user.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.userName", is(user.getUserName())));
    }

    @Test
    public void findOneAndNotReadableId() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.findOne(user.getId())).willReturn(user);

        mvc.perform(get("/users/{id}", "abcd")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void update() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.update(user)).willReturn(user);

        mvc.perform(put("/users/{id}", user.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.write(user).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId().intValue())))
                .andExpect(jsonPath("$.userName", is(user.getUserName())));
    }

    @Test
    public void updateAndUnsupportedMediaType() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.update(user)).willReturn(user);

        mvc.perform(put("/users/{id}", user.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void updateAndRequestBodyNotReadable() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));
        given(userService.update(user)).willReturn(user);

        mvc.perform(put("/users/{id}", user.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteOne() throws Exception {
        User user = json.readObject(new ClassPathResource("user.json"));

        mvc.perform(delete("/users/{id}", user.getId()))
                .andExpect(status().isNoContent());
    }
}
