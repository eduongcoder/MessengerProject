package com.example.chatservice.Controller;

import com.example.chatservice.Dto.Request.MessageRequest;
import com.example.chatservice.Dto.Request.UserMemberRequest;
import com.example.chatservice.Dto.Response.ApiResponse;
import com.example.chatservice.Dto.Response.MessageResponse;
import com.example.chatservice.Dto.Response.UserMemberResponse;
import com.example.chatservice.Form.MessageUpdate;
import com.example.chatservice.Form.UserMemberUpdate;
import com.example.chatservice.Service.MessageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class MessageController {
    MessageService messageService;
    @GetMapping( name = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<MessageResponse>> getAllmemberInRoom(@PathVariable String id) {
        // Get all rooms
        return ApiResponse.<List<MessageResponse>>builder()
               .code(0)
               .result(messageService.getMessagesInRoom(id))
               .message("All Messages")
               .build();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<MessageResponse>  createUserMember(@RequestBody MessageRequest request) {
        // Create a new room
        return ApiResponse.<MessageResponse>builder()
                .code(0)
                .result(messageService.createMessage(request))
                .message("Message created successfully")
                .build();
    }
    @PutMapping( name = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<MessageResponse>  changeUserName(@RequestBody MessageUpdate request, @PathVariable String id) {
        // Create a new room
        return ApiResponse.<MessageResponse>builder()
                .code(0)
                .result(messageService.UpdateMessage(request,id))
                .message("Message updated successfully")
                .build();
    }
    @DeleteMapping( name = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String>  changeUserName(@PathVariable String id) {
        // Create a new room
        return ApiResponse.<String>builder()
                .code(0)
                .result(messageService.deletedMessage(id))
                .message("Deleted Message successfully")
                .build();
    }

}
