package com.example.chatservice.Dto.Response;

import com.example.chatservice.Entity.Room;
import com.example.chatservice.Entity.UserMember;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Document(collection = "message")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {
     String messageId; // Primary Key
     String type; // e.g., Message, File, Image
     String message;
     String status; // Pending, Access, Reject
    UserMember sender; // Reference to sender (UserMember)
    Room room; // Reference to the Room
     LocalDateTime sentAt;
     LocalDateTime updateAt;
}
