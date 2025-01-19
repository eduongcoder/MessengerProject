package com.example.demo.repository.http;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "profile-user-service",url = "${app.services.profile}")
public interface ProfileUser {
	
}
