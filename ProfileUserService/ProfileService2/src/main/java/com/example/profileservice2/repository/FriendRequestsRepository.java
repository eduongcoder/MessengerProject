package com.example.profileservice2.repository;

import com.example.profileservice2.entity.FriendRequests;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestsRepository extends Neo4jRepository<FriendRequests, String> {
    List<FriendRequests> findByReceiverUser(String receiverUser);
    List<FriendRequests> findBySenderUser(String senderUser);
}
