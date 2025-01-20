package com.example.profileservice2.openfeign;

import com.example.profileservice2.DTO.Request.UserIdentityCreationRequest;
import com.example.profileservice2.DTO.Response.ApiRespone;
import com.example.profileservice2.DTO.Response.UserIdentityRespone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "auth-service", url = "http://localhost:8081/room") // Thay thế bằng URL của AuthService

public class ChatServiceClient {
    @GetMapping(value="/useridentity/decodeToken")
    String getListRoom(@RequestParam List authorizationHeader);


}
