package com.example.demo.repository.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.respone.UserReponse;

@FeignClient(name = "profile-user-service",url = "${app.services.profile}")
public interface ProfileUser {
    @PostMapping(value = "/api/users/getubtoken",produces  =MediaType.APPLICATION_JSON_VALUE)
	UserReponse login(@RequestParam String token);
}
