package com.example.chatservice.Controller;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Response.ApiResponse;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Form.RoomUpdate;
import com.example.chatservice.Service.RoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoomController {
    private final RoomService roomService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<RoomResponse>> getAllRooms() {
        // Get all rooms
        return ApiResponse.<List<RoomResponse>>builder()
               .code(0)
               .result(roomService.getallrooms())
               .message("All rooms")
               .build();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<RoomResponse>  createRoom(@RequestBody RoomRequest request) {
        // Create a new room
        return ApiResponse.<RoomResponse>builder()
                .code(0)
                .result(roomService.createRoom(request))
                .message("Room created successfully")
                .build();
    }
    @PutMapping( name = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<RoomResponse>  changeRoomName(@RequestBody RoomUpdate request,@PathVariable String id) {
        // Create a new room
        return ApiResponse.<RoomResponse>builder()
                .code(0)
                .result(roomService.changeRoomName(request,id))
                .message("Room updated successfully")
                .build();
    }

}
