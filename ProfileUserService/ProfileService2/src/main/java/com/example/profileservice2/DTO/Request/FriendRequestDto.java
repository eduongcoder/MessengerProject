package com.example.profileservice2.DTO.Request;

import com.example.profileservice2.entity.FriendRequests;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class FriendRequestDto {
    private String request_id;       // Unique ID for the friend request
    private String senderUser;      // ID of the user sending the request
    private String receiverUser;    // ID of the user receiving the request
    private String status;          // Status of the request (e.g., PENDING, FRIENDS, DECLINED)
    private Date createdAt;         // Timestamp for when the request was created
    private Date updatedAt;         // Timestamp for when the request was last updated

    public FriendRequestDto() {
    }

    public FriendRequestDto(String requestId, String senderUser, String receiverUser, String status, Date createdAt, Date updatedAt) {
        this.request_id = requestId;
        this.senderUser = senderUser;
        this.receiverUser = receiverUser;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public String getRequestId() {
        return request_id;
    }

    public void setRequestId(String requestId) {
        this.request_id = requestId;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(String senderUser) {
        this.senderUser = senderUser;
    }

    public String getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(String receiverUser) {
        this.receiverUser = receiverUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    // Optional: Add additional fields if needed (e.g., sender/receiver usernames or avatars)
}

