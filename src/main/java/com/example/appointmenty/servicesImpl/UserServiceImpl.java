package com.example.appointmenty.servicesImpl;

import com.example.appointmenty.dtos.UpdateUserDTO;
import com.example.appointmenty.models.User;
import com.example.appointmenty.repositories.IUserRepository;
import com.example.appointmenty.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(UUID userID){
        return userRepository.findById(userID);
    }

    @Override
    public ResponseEntity<?> updateUser(UUID userID, UpdateUserDTO dto){

        Optional<User> findById = userRepository.findById(userID);
        if(findById.isPresent()) {
            User user = findById.get();

            if(userRepository.existsByName(dto.getName()) &&
                    !(user.getName().equalsIgnoreCase(dto.getName()))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with that name exists already!");
            }

            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User does not exist.");
    }
}
