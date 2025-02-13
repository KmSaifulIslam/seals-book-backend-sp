package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.service.UserService;
import org.example.sealsbookbackendsp.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject the PasswordEncoder

    // Registration endpoint
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Ensure user is not already registered
        if (userService.existsByEmail(user.getEmail())) {
//            return ResponseEntity.badRequest().body("Email already in use");
        }

        // Encrypt the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Use passwordEncoder to encode password
        user.setRole(user.getRole());
        String token = jwtService.generateToken(user.getEmail());
        user.setToken(token);

        userService.saveUser(user);

        User userDetails = userService.loadUserByUserEmail(user.getEmail());

        return ResponseEntity.ok(userDetails);
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // Authenticate and generate JWT token
        if (!userService.existsByEmail(user.getEmail())) {
//            return ResponseEntity.badRequest().body("User not found.");
        }

        String token = jwtService.generateToken(user.getEmail());

        user.setToken(token);
        User userData =  userService.updateUserToken(user);

        return ResponseEntity.ok(userData);
//        return ResponseEntity.ok("Bearer " + token); // Send back the token in the response
    }
}
