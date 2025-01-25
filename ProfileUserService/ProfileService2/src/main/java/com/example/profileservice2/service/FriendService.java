package com.example.profileservice2.service;

import com.example.profileservice2.DTO.Request.FriendDto;
import com.example.profileservice2.entity.Friends;
import com.example.profileservice2.repository.FriendsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class FriendService {

    private final FriendsRepository friendsRepository;

    @Autowired
    public  FriendService(FriendsRepository repo){
        friendsRepository = repo;
    }
    public List<FriendDto> getFriends(String userId) {
        Optional<Friends> friends = friendsRepository.findById(userId);
        return friends.stream()
                .map(FriendDto::new)
                .collect(Collectors.toList());
    }
}
