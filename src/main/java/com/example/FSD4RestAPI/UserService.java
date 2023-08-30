package com.example.FSD4RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AppUser  createUser(AppUser  user) {
        return userRepository.save(user);
    }
    
    public AppUser  findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    // You can add other methods for user operations
}
