package com.example.profileservice2.controller;

import com.example.profileservice2.DTO.Request.FriendDto;
import com.example.profileservice2.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
//@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;
    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendDto>> getFriends(@PathVariable String userId) {
        return ResponseEntity.ok(friendService.getFriends(userId));
    }


}

