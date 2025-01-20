package com.example.profileservice2.DTO.Response;

import lombok.*;

import java.util.Date;
import java.util.List;

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
    private List room;

}
