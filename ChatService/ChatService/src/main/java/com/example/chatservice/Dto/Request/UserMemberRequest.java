package com.example.chatservice.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserMemberRequest {
    String nameUser;
    String userId;
    String room;


}
