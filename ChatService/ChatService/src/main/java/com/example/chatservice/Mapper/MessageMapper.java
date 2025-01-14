package com.example.chatservice.Mapper;

import com.example.chatservice.Dto.Request.MessageRequest;
import com.example.chatservice.Dto.Request.UserMemberRequest;
import com.example.chatservice.Dto.Response.MessageResponse;
import com.example.chatservice.Dto.Response.UserMemberResponse;
import com.example.chatservice.Entity.Message;
import com.example.chatservice.Entity.UserMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "room",ignore = true)
    @Mapping(target = "sender",ignore = true)
    Message toMessage(MessageRequest request);
    MessageResponse toMessageResponse(Message entity);
}
