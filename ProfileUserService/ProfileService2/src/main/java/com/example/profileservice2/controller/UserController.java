package com.example.profileservice2.controller;

import com.example.profileservice2.DTO.Request.UserRequest;
import com.example.profileservice2.DTO.Response.UserReponse;
import com.example.profileservice2.entity.User;
import com.example.profileservice2.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
//@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE ,makeFinal = true)
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest userDto) {
        try {
            User registeredUser = userService.registerUser(userDto);
            return ResponseEntity.ok(registeredUser);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
//    @GetMapping ("/{userid}")
//    public UserReponse getProfile (@PathVariable UUID userid){
//        return userService.getUserByUsername(userid);
//    }

    @PostMapping("/getubtoken")
    public ResponseEntity<?> login( String token) {
        UserReponse user = userService.getUserProfile(token);
        return ResponseEntity.ok(user);
    }

}
