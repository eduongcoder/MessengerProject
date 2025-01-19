package com.example.profileservice2.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Node("User")
@FieldDefaults(level = AccessLevel.PRIVATE )
public class User {

    @Id
    String id;

    String username;
    String email;
    String password;
    String avatar;
    String phonenumber;
    Boolean isactive;
    Date createdAt;
    Date updatedAt;

    public User() {
        this.id = UUID.randomUUID().toString(); // Tạo UUID dạng String khi tạo object

    }

    public User(String id, String username, String email, String password, String avatar, String phonenumber, Boolean isactive, Date createdAt, Date updatedAt) {
        this.id = UUID.randomUUID().toString(); // Tạo UUID dạng String khi tạo object
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.phonenumber = phonenumber;
        this.isactive = isactive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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
}
