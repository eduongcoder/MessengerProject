package com.example.profileservice2.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Node("Friends")
@FieldDefaults(level = AccessLevel.PRIVATE )
public class Friends {
    @Id

    String user_id;

    String sender_user;
    String receiver_user;
    String status;
    String send_user; //fk
    String user_receive; //fk
    Date createdAt;
    Date updatedAt;

    public Friends(String user_id, String sender_user, String receiver_user, String status, String send_user, String user_receive, Date createdAt, Date updatedAt) {
        this.user_id = UUID.randomUUID().toString(); // Tạo UUID dạng String khi tạo object
        this.sender_user = sender_user;
        this.receiver_user = receiver_user;
        this.status = status;
        this.send_user = send_user;
        this.user_receive = user_receive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSender_user() {
        return sender_user;
    }

    public void setSender_user(String sender_user) {
        this.sender_user = sender_user;
    }

    public String getReceiver_user() {
        return receiver_user;
    }

    public void setReceiver_user(String receiver_user) {
        this.receiver_user = receiver_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSend_user() {
        return send_user;
    }

    public void setSend_user(String send_user) {
        this.send_user = send_user;
    }

    public String getUser_receive() {
        return user_receive;
    }

    public void setUser_receive(String user_receive) {
        this.user_receive = user_receive;
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
