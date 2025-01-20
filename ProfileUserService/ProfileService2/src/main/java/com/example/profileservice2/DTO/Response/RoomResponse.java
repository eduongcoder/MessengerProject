package com.example.profileservice2.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomResponse {
    String idRoom;
    /*
    Ý nghĩa của ReceivedUser:
        ID của người nhận trong các phòng chat 1-1 (chat cá nhân).
        Trong trường hợp phòng nhóm, trường này có thể để trống hoặc không được sử dụng.
    */
    List userMembers;
    String roomName;
    String backGroundRoom;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
