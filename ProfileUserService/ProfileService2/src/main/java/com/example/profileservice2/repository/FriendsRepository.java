package com.example.profileservice2.repository;

import com.example.profileservice2.entity.Friends;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface FriendsRepository extends Neo4jRepository<Friends, String> {
}
