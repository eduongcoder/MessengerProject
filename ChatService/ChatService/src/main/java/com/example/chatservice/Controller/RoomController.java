package com.example.chatservice.Controller;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Service.RoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomController {
    private final RoomService roomService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomResponse createRoom(@RequestBody RoomRequest request) {
        // Create a new room
        log.info(request.toString());
        return roomService.createRoom(request);
    }
}
