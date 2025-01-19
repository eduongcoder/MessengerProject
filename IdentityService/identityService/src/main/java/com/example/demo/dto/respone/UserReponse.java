package com.example.demo.dto.respone;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class UserReponse {
    private String id;
    private String username;

    private String email;
    private String avatar;
    private String phonenumber;
    private Boolean isactive;
    private Date createdAt;
    private Date updatedAt;

}
