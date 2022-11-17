package com.example.appointmenty.servicesImpl;

import com.example.appointmenty.models.User;
import com.example.appointmenty.repositories.IUserRepository;
import com.example.appointmenty.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
}
