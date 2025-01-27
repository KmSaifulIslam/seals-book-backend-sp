package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or update user
    public User saveUser(User user) {
        return userRepository.save(user); // This works for both create and update
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Find user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

