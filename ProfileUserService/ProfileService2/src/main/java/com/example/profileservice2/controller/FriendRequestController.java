package com.example.profileservice2.controller;

import com.example.profileservice2.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend-requests")
@RequiredArgsConstructor
public class FriendRequestController {

    private final FriendRequestService friendRequestService;

    @PostMapping("/send")
    public ResponseEntity<ApiResponse> sendFriendRequest(@RequestBody FriendRequestDto requestDto) {
        return ResponseEntity.ok(friendRequestService.sendFriendRequest(requestDto));
    }

    @PostMapping("/accept")
    public ResponseEntity<ApiResponse> acceptFriendRequest(@RequestBody RequestActionDto actionDto) {
        return ResponseEntity.ok(friendRequestService.acceptFriendRequest(actionDto.getRequestId()));
    }

    @PostMapping("/decline")
    public ResponseEntity<ApiResponse> declineFriendRequest(@RequestBody RequestActionDto actionDto) {
        return ResponseEntity.ok(friendRequestService.declineFriendRequest(actionDto.getRequestId()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendRequestDto>> getFriendRequests(@PathVariable String userId) {
        return ResponseEntity.ok(friendRequestService.getFriendRequests(userId));
    }
}

