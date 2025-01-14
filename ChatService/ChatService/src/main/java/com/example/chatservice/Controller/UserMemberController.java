package com.example.chatservice.Controller;

import com.example.chatservice.Dto.Request.RoomRequest;
import com.example.chatservice.Dto.Request.UserMemberRequest;
import com.example.chatservice.Dto.Response.ApiResponse;
import com.example.chatservice.Dto.Response.RoomResponse;
import com.example.chatservice.Dto.Response.UserMemberResponse;
import com.example.chatservice.Form.RoomUpdate;
import com.example.chatservice.Form.UserMemberUpdate;
import com.example.chatservice.Service.UserMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermembers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserMemberController {
    UserMemberService userMemberService;
    @GetMapping( name = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<UserMemberResponse>> getAllmemberInRoom(@PathVariable String id) {
        // Get all rooms
        return ApiResponse.<List<UserMemberResponse>>builder()
               .code(0)
               .result(userMemberService.getUsersInRoom(id))
               .message("All rooms")
               .build();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<UserMemberResponse>  createUserMember(@RequestBody UserMemberRequest request) {
        // Create a new room
        return ApiResponse.<UserMemberResponse>builder()
                .code(0)
                .result(userMemberService.createUserMember(request))
                .message("User_Member created successfully")
                .build();
    }
    @PutMapping( name = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<UserMemberResponse>  changeUserName(@RequestBody UserMemberUpdate request, @PathVariable String id) {
        // Create a new room
        return ApiResponse.<UserMemberResponse>builder()
                .code(0)
                .result(userMemberService.changeUserMemberName(request,id))
                .message("Room updated successfully")
                .build();
    }

}
