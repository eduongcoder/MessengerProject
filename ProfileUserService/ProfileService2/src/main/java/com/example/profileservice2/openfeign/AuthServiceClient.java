package com.example.profileservice2.openfeign;

import com.example.profileservice2.DTO.Request.LoginRequest;
import com.example.profileservice2.DTO.Response.LoginRespone;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://localhost:8082/identity") // Thay thế bằng URL của AuthService
public interface AuthServiceClient {

    @PostMapping(value="/useridentity/token")
    LoginRespone ApiRespone(@RequestBody String String);
}