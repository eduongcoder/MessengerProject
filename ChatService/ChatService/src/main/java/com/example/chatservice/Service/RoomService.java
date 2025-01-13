package com.example.chatservice.Service;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Entity.Room;
import com.example.chatservice.Mapper.RoomMapper;
import com.example.chatservice.Repository.RoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomService {

    RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomResponse createRoom(RoomRequest request){
        Room room = roomMapper.toRoom(request);
        room.setCreateAt(LocalDateTime.now());
        log.info(request.getRoomName());
        return roomMapper.toRoomResponse(roomRepository.save(room));
    }
}
