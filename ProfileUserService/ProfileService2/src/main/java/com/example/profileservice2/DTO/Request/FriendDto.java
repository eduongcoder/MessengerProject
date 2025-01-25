package com.example.profileservice2.DTO.Request;

import com.example.profileservice2.entity.Friends;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendDto {
    private String friendId;   // ID của bạn bè
    private String username;   // Tên người dùng bạn bè
    private String email;      // Email của bạn bè
    private String avatar;     // Avatar của bạn bè

    public FriendDto(Friends friends) {
        this.friendId = friends.getUser_id(); // ID bạn bè
        this.username = friends.getSender_user(); // Tạm dùng sender_user, bạn có thể thay đổi theo logic
        this.email = null;  // Giá trị này bạn cần ánh xạ từ User (nếu có)
        this.avatar = null; // Giá trị này bạn cần ánh xạ từ User (nếu có)
    }
}
