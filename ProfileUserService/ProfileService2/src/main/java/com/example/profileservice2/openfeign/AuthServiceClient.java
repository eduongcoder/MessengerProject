package com.example.profileservice2.openfeign;

@FeignClient(name = "auth-service", url = "http://localhost:8081") // Thay thế bằng URL của AuthService
public interface AuthServiceClient {

    @PostMapping("/api/auth/login")
    AuthResponse login(@RequestBody LoginRequest loginRequest);
}