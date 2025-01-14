package com.example.chatservice.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "user_member")
public class UserMember {
    @Id
    String userMemberId;

    String nameUser;
    String role;
    String userId;

    @DBRef
    Room room;

    @DBRef
    List<Message> messages;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
