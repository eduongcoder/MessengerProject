package com.example.profileservice2.service;

import com.example.profileservice2.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendsRepository friendsRepository;

    public List<FriendDto> getFriends(String userId) {
        List<Friends> friends = friendsRepository.findByUserId(userId);
        return friends.stream()
                .map(FriendDto::new)
                .collect(Collectors.toList());
    }
}
