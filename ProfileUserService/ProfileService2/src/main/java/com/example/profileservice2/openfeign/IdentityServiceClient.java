package com.example.profileservice2.openfeign;

import com.example.profileservice2.DTO.Request.UserIdentityCreationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-service", url = "http://localhost:8082/identity") // Thay thế bằng URL của AuthService
public interface IdentityServiceClient {

    @GetMapping(value="/useridentity/decodeToken")
    String decodeToken(@RequestParam String authorizationHeader);
    @GetMapping(value="/useridentity/createUserIdentity")
    String createUserIdentity(@RequestParam UserIdentityCreationRequest request);

} 