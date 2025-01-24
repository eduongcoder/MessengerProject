package com.example.profileservice2.service;

import com.example.profileservice2.DTO.Request.FriendRequestDto;
import com.example.profileservice2.DTO.Response.ApiRespone;
import com.example.profileservice2.entity.FriendRequests;
import com.example.profileservice2.entity.User;
import com.example.profileservice2.repository.FriendRequestsRepository;
import com.example.profileservice2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendRequestService {

    private final FriendRequestsRepository friendRequestRepository;
    private final UserRepository userRepository;

    public ApiRespone sendFriendRequest(FriendRequestDto requestDto) {
        // Check if users exist
        User sender = userRepository.findById(requestDto.getSenderUser())
                .orElseThrow(() -> new RuntimeException("Sender not found"));
        User receiver = userRepository.findById(requestDto.getReceiverUser())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        // Save friend request
        FriendRequests request = new FriendRequests();
        request.setSender_user(sender.getId());
        request.setReceiver_user(receiver.getId());
        request.setStatus("PENDING");
        request.setCreatedAt(new Date());
        friendRequestRepository.save(request);

        return new ApiRespone("Friend request sent successfully", "PENDING", request.getRequest_id());
    }

    public ApiRespone acceptFriendRequest(String requestId) {
        FriendRequests request = friendRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));


        request.setStatus("FRIENDS");
        request.setUpdatedAt(new Date());
        friendRequestRepository.save(request);

        return new ApiRespone("Friend request accepted successfully", "FRIENDS");
    }

    public ApiRespone declineFriendRequest(String requestId) {
        FriendRequests request = friendRequestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        request.setStatus("DECLINED");
        request.setUpdatedAt(new Date());
        friendRequestRepository.save(request);

        return new ApiRespone("Friend request declined", "DECLINED");
    }

    public List<FriendRequestDto> getFriendRequests(String userId) {
        List<FriendRequests> receivedRequests = friendRequestRepository.findByReceiverUser(userId);
        List<FriendRequests> sentRequests = friendRequestRepository.findBySenderUser(userId);

        // Convert to DTOs
        List<FriendRequestDto> requests = new ArrayList<>();
        receivedRequests.forEach(request -> requests.add(new FriendRequestDto(request.getRequest_id(),request.getSender_user(), request.getReceiver_user(), request.getStatus(),request.getCreatedAt(),request.getUpdatedAt())));
        sentRequests.forEach(request -> requests.add(new FriendRequestDto(request.getRequest_id(),request.getSender_user(), request.getReceiver_user(), request.getStatus(),request.getCreatedAt(),request.getUpdatedAt())));

        return requests;
    }
}

