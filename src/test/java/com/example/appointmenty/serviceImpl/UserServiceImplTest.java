package com.example.appointmenty.serviceImpl;

import com.example.appointmenty.dtos.UpdateUserDTO;
import com.example.appointmenty.repositories.IUserRepository;
import com.example.appointmenty.models.User;
import com.example.appointmenty.servicesImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void getAll(){
        when(userRepositoryMock.findAll()).thenReturn(Arrays.asList(
                new User(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"),
                "John", "john@gmail.com"),
                new User(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"),
               "Deo", "" +    "deo@gmail.com")));

        assertEquals("deo@gmail.com", userService.getAll().get(1).getEmail());
        assertEquals(2,userService.getAll().size());
    }

    @Test
    public void update_fail(){
        UpdateUserDTO dto = new UpdateUserDTO("John", "john@gmail.com");
        when(userRepositoryMock.getById(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"))).thenReturn(null);

        ResponseEntity<?> updateUser = userService.updateUser(UUID.fromString("db617be3-f2ab-4421-aa6d-ca37e51791e6"), dto);
        assertEquals("User does not exist.", updateUser.getBody());
        assertTrue(updateUser.getStatusCode().is4xxClientError());
    }

}
