package com.example.appointmenty.controllers;

import com.example.appointmenty.dtos.CreateUserDTO;
import com.example.appointmenty.models.User;
import com.example.appointmenty.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(
            @RequestBody  CreateUserDTO createUserDTO
            ) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        return userService.create(user);
    }

    @GetMapping("/")
    public String test(){
        return "Hello World";
    }
}
