package com.example.profileservice.repository;

import com.example.profileservice.entity.FriendRequests;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRequestsRepository extends Neo4jRepository<FriendRequests,String> {
}
