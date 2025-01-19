package com.example.profileservice2.DTO.Request;

import lombok.*;

@Getter
@Setter
@Builder
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String phonenumber;

    public UserRequest() {
    }

    public UserRequest(String username, String email, String password, String avatar, String phonenumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
