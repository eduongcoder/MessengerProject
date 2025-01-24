package com.example.profileservice2.controller;

@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendController {

    private final FriendService friendService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendDto>> getFriends(@PathVariable String userId) {
        return ResponseEntity.ok(friendService.getFriends(userId));
    }
}

