package com.example.profileservice2.repository;

import com.example.profileservice2.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
    boolean existsByUsername(String username);

    // Kiểm tra email có tồn tại
    boolean existsByEmail(String email);
}
