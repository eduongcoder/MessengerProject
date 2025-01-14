package com.example.profileservice.repository;

import com.example.profileservice.entity.Friends;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;

public interface FriendsRepository extends Neo4jRepository<Friends, String> {
}
