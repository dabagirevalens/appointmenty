package com.example.appointmenty.controllers;

import com.example.appointmenty.dtos.CreateUserDTO;
import com.example.appointmenty.models.User;
import com.example.appointmenty.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public User registerUser(
            @RequestBody  CreateUserDTO createUserDTO
            ) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        return userService.create(user);
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
}
