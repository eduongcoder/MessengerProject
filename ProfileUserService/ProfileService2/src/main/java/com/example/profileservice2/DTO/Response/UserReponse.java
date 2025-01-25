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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List getRoom() {
        return room;
    }

    public void setRoom(List room) {
        this.room = room;
    }
}
