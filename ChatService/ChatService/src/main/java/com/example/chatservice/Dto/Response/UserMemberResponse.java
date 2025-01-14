package com.example.chatservice.Dto.Response;

import com.example.chatservice.Entity.Room;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserMemberResponse {
    String userMemberId;
    String nameUser;
    String role;
    String userId;
    RoomResponse room;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
