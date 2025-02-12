//package org.example.sealsbookbackendsp.mapper;
//
//import org.example.sealsbookbackendsp.dto.UserDto;
//import org.example.sealsbookbackendsp.model.User;
//import org.example.sealsbookbackendsp.request.UserRequest;
//import org.example.sealsbookbackendsp.response.UserResponse;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserMapper {
//
////    public UserDto toDto(User user) {
////        return new UserDto(
////                user.getId(),
////                user.getName(),
////                user.getPassword(),  // Ensure you're passing the password here
////                user.getEmail(),
////                user.getPhone(),
////                user.getRole(),
////                user.getImageUrl(),
////                user.getToken(),
////                user.getUpdateTime(),
////                user.getCreate_at()
////        );
////    }
//
//    // Convert UserRequest to User entity (for save or update)
//    public User toEntity(UserRequest userRequest) {
//        User user = new User();
//        user.setName(userRequest.getName());
//        user.setEmail(userRequest.getEmail());
//        user.setPhone(userRequest.getPhone());
//        user.setRole(userRequest.getRole());
//        user.setImageUrl(userRequest.getImageUrl());
//        user.setToken(userRequest.getToken());
//        user.setPassword(userRequest.getPassword());
////        user.setCreateAt(userRequest);
//        user.setPassword(userRequest.getPassword()); // Set the password
//        return user;
//    }
//
//    // Convert User entity to UserResponse (for response)
//    public UserResponse toResponse(User user) {
//        return new UserResponse(
//                user.getId(),
//                user.getName(),
//                user.getEmail(),
//                user.getPhone(),
//                user.getRole(),
//                user.getPassword(),
//                user.getImageUrl(),
//                user.getToken(),
//                user.getCreateAt(),
//                user.getUpdateTime()
//        );
//    }
//}
