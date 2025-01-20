package com.example.chatservice.Mapper;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Request.UserMemberRequest;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Dto.Response.UserMemberResponse;
import com.example.chatservice.Entity.Room;
import com.example.chatservice.Entity.UserMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMemberMapper {
    @Mapping(target = "room",ignore = true)
    UserMember toUserMember(UserMemberRequest request);
    UserMemberResponse toUserMemberResponse(UserMember entity);
}
