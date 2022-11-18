package com.example.appointmenty.services;

import com.example.appointmenty.dtos.UpdateUserDTO;
import com.example.appointmenty.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    User create(User user);

    List<User> getAll();

    Optional<User> getById(UUID userId);

    ResponseEntity<?> updateUser(UUID userID, UpdateUserDTO dto);
}
