package com.example.chatservice.Entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
    String receivedUser;
    String roomName;
    String backGroundRoom;
    LocalDateTime createAt;
    LocalDateTime updateAt;


}
