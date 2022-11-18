package com.example.appointmenty.repositoty;

import com.example.appointmenty.repositories.IUserRepository;
import com.example.appointmenty.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private IUserRepository userRepository;

    @Test
    public void findAll_success() {
        List<User> users = userRepository.findAll();
        assertEquals(1, users.size());
    }
}
