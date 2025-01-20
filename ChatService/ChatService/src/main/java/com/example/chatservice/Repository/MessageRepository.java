package com.example.chatservice.Repository;

import com.example.chatservice.Entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message,String> {
    List<Message> findByRoom_IdRoom(String roomId);
}
