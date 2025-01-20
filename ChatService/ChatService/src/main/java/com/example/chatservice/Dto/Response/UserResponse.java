package com.example.chatservice.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String userid;
    String email;
    String password;
    boolean isActive;
    String phoneNumber;

}
