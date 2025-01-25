package com.example.profileservice2.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "room", url = "http://localhost:8081/room") // Thay thế bằng URL của AuthService

public interface ChatServiceClient {
    @GetMapping(value = "/{id}")
    public List getAllRooms(@PathVariable String id) ;

}
