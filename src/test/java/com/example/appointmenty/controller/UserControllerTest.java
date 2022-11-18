package com.example.appointmenty.controller;

import com.example.appointmenty.controllers.UserController;
import com.example.appointmenty.models.User;
import com.example.appointmenty.servicesImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private UserServiceImpl userServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll_success() throws Exception {
        List<User> users =Arrays.asList(
                new User(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"),
                        "John", "john@gmail.com"),
                new User(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"),
                        "Deo", "" +    "deo@gmail.com"));
        when(userServiceMock.getAll()).thenReturn(users);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult  mvcResult = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }
}
