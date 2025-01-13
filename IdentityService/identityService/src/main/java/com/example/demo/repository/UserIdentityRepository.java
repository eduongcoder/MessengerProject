package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserIdentity;

@Repository
public interface UserIdentityRepository extends JpaRepository<UserIdentity, String>{

}
