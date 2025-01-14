package com.example.chatservice.Dto.Request;

import com.example.chatservice.Entity.Room;
import com.example.chatservice.Entity.UserMember;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageRequest {

     String type; // e.g., Message, File, Image
     String message;
     String sender; // Reference to sender (UserMember)
     String room; // Reference to the Room

}
