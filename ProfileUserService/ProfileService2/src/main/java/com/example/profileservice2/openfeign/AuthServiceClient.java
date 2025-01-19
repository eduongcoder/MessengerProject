package com.example.profileservice2.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", url = "http://localhost:8082/identity") // Thay thế bằng URL của AuthService
public interface AuthServiceClient {

    @GetMapping(value="/useridentity/decodeToken")
    String decodeToken(@RequestParam String authorizationHeader);
} 