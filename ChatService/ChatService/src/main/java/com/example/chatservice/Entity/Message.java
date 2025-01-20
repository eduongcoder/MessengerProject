package com.example.chatservice.Entity;

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
public class Message {
    @Id
     String messageId; // Primary Key
     String type; // e.g., Message, File, Image
     String message;
     String status; // Pending, Access, Reject

    @DBRef
     UserMember sender; // Reference to sender (UserMember)

    @DBRef
     Room room; // Reference to the Room

     LocalDateTime sentAt;
     LocalDateTime updateAt;
}
