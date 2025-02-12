package org.example.sealsbookbackendsp.service;

import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email: " + email));

        return new CustomUserDetails(user);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUserToken(User user) {
        User user1 = userRepository.findByEmail(user.getEmail()).get();
        user1.setToken(user.getToken());
        return userRepository.save(user1);
    }
}
