package com.example.chatservice.Service;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Entity.Room;
import com.example.chatservice.Exception.AppException;
import com.example.chatservice.Exception.ErrorCode;
import com.example.chatservice.Form.RoomUpdate;
import com.example.chatservice.Mapper.RoomMapper;
import com.example.chatservice.Repository.RoomRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public RoomResponse changeRoomName(RoomUpdate roomRequest, String RoomId){
        Room room = roomRepository.findById(RoomId)
                .orElseThrow(()->new AppException(ErrorCode.NOTFOUND_ROOM));
        room.setRoomName(roomRequest.getRoomName());
        room.setUpdateAt(LocalDateTime.now());
        //khi người dùng đổi tên room thì sẽ lấy id của user nhận đổi t luôn
        return roomMapper.toRoomResponse(roomRepository.save(room));
    }
    public List<RoomResponse> getallrooms(){
        return roomRepository.findAll().stream()
                .map(roomMapper::toRoomResponse).collect(Collectors.toList());
    }
}
