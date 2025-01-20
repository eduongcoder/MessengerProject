package com.example.chatservice.Repository;

import com.example.chatservice.Entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    List<Room> findByUserMembers_UserId(String userId);

}
