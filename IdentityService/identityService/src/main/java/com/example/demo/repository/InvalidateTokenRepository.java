package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.InvalidatedToken;

public interface InvalidateTokenRepository extends JpaRepository<InvalidatedToken, String>{
	
}
