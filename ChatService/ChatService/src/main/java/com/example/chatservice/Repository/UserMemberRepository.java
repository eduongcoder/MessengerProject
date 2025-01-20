package com.example.chatservice.Repository;

import com.example.chatservice.Entity.UserMember;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMemberRepository extends MongoRepository<UserMember,String> {
    List<UserMember> findByRoom_IdRoom(String roomId);
}
