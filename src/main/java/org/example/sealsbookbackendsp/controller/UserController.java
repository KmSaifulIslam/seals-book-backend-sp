package org.example.sealsbookbackendsp.controller;

import org.example.sealsbookbackendsp.mapper.UserMapper;
import org.example.sealsbookbackendsp.model.User;
import org.example.sealsbookbackendsp.request.UserRequest;
import org.example.sealsbookbackendsp.response.UserResponse;
import org.example.sealsbookbackendsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    // Hello API endpoint
    @GetMapping("/hello")
    public ResponseEntity<String> helloApi() {
        return new ResponseEntity<>("Hello, welcome to the User API!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            List<UserResponse> userResponses = users.stream()
                    .map(userMapper::toResponse)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(userResponses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        User savedUser = userService.saveUser(user);
        UserResponse userResponse = userMapper.toResponse(savedUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }


    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        Optional<User> existingUser = userService.getUserById(id);
        if (existingUser.isPresent()) {
            User user = userMapper.toEntity(userRequest);  // Convert to entity
            user.setId(id);  // Ensure the ID is set
            User updatedUser = userService.saveUser(user);  // Save the updated user
            UserResponse userResponse = userMapper.toResponse(updatedUser);  // Convert to response
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(u -> new ResponseEntity<>(userMapper.toResponse(u), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @GetMapping("/login")
//    public ResponseEntity<UserResponse> loginUser(
//            @RequestParam String email,
//            @RequestParam String password) {
//
//        Optional<User> user = Optional.ofNullable(userService.getUserByEmailAndPassword(email, password));
//
//        if (user.isPresent()) {
//            UserResponse userResponse = userMapper.toResponse(user.get());
//            return new ResponseEntity<>(userResponse, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
//        Optional<User> user = userService.getUserByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());
//
//        if (user.isPresent()) {
//            UserResponse userResponse = userMapper.toResponse(user.get());  // Extract the User from Optional
//            return new ResponseEntity<>(userResponse, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
        Optional<User> user = userService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok(userMapper.toResponse(user.get()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }




}
