package com.example.profileservice2.controller;

import com.example.profileservice2.DTO.Request.FriendRequestDto;
import com.example.profileservice2.DTO.Request.RequestActionDto;
import com.example.profileservice2.DTO.Response.ApiRespone;
import com.example.profileservice2.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend-requests")
@RequiredArgsConstructor
public class FriendRequestController {

    private final FriendRequestService friendRequestService;

    @Autowired
    public FriendRequestController(FriendRequestService friendRequestService) {
        this.friendRequestService = friendRequestService;
    }
    @PostMapping("/send")
    public ResponseEntity<ApiRespone> sendFriendRequest(@RequestBody FriendRequestDto requestDto) {
        return ResponseEntity.ok(friendRequestService.sendFriendRequest(requestDto));
    }

    @PostMapping("/accept")
    public ResponseEntity<ApiRespone> acceptFriendRequest(@RequestBody RequestActionDto actionDto) {
        return ResponseEntity.ok(friendRequestService.acceptFriendRequest(actionDto.getRequestId()));
    }

    @PostMapping("/decline")
    public ResponseEntity<ApiRespone> declineFriendRequest(@RequestBody RequestActionDto actionDto) {
        return ResponseEntity.ok(friendRequestService.declineFriendRequest(actionDto.getRequestId()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendRequestDto>> getFriendRequests(@PathVariable String userId) {
        return ResponseEntity.ok(friendRequestService.getFriendRequests(userId));
    }
}

