package com.example.chatservice.Entity;


import com.example.chatservice.Dto.Response.UserResponse;
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
@Document(collection = "room")
public class Room {
    @Id
    String idRoom;
    /*
    Ý nghĩa của ReceivedUser:
        ID của người nhận trong các phòng chat 1-1 (chat cá nhân).
        Trong trường hợp phòng nhóm, trường này có thể để trống hoặc không được sử dụng.
    */
    @DBRef
     List<UserMember> userMembers;

    @DBRef
    List<Message> messages;
    String receivedUser;
    String roomName;
    String backGroundRoom;

    LocalDateTime createAt;
    LocalDateTime updateAt;


}
