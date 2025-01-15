package com.example.profileservice.repository;

import com.example.profileservice.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends Neo4jRepository<User, String> {
    boolean existsByUsername(String username);

    // Kiểm tra email có tồn tại
    boolean existsByEmail(String email);
}
