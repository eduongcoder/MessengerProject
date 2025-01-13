package com.example.chatservice.Mapper;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(RoomRequest request);
    RoomResponse toRoomResponse(Room entity);
}
