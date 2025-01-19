package com.example.profileservice.DTO;

import lombok.*;

@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    String username;
    String email;
    String password;
    String avatar;
    String phonenumber;
}

