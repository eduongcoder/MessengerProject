package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.UserIdentityCreationRequest;
import com.example.demo.dto.respone.ApiRespone;
import com.example.demo.dto.respone.LoginRespone;
import com.example.demo.dto.respone.UserIdentityRespone;
import com.example.demo.entity.UserIdentity;
import com.example.demo.service.UserIdentityService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/useridentity")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserIdentityController {

	UserIdentityService userIdentityService;
	
	
	
	@PostMapping("/token")
	public ApiRespone<LoginRespone> generateToken(@RequestBody LoginRequest request){
		
		return ApiRespone.<LoginRespone>builder().result(userIdentityService.getUserIdentity(request)).build();
	}
	
	@PostMapping("/createUserIdentity")
	public ApiRespone<UserIdentityRespone> createUserIdentity(@RequestBody UserIdentityCreationRequest request){
		return ApiRespone.<UserIdentityRespone>builder().result(userIdentityService.createUserIdentity(request)).build();
	}
	
	
}
