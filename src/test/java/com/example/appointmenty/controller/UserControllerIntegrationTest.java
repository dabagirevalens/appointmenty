package com.example.appointmenty.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll_success() throws JSONException {
        String response = restTemplate.getForObject("/api/v1/users", String.class);
        System.out.println(response);

        JSONAssert.assertEquals("[{\"id\":\"db617be3-f2ab-4421-aa6d-ca37e51791e6\",\"name\":\"dabagire\",\"email\":\"email@gmail.com\"},{\"id\":\"db617be3-f2ab-4421-aa6d-ca37e51791e7\",\"name\":\"Deo\",\"email\":\"deo@gmail.com\"}]", response, false);
    }

}
