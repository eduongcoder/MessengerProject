package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.UserIdentityCreationRequest;
import com.example.demo.dto.respone.ApiRespone;
import com.example.demo.dto.respone.LoginRespone;
import com.example.demo.dto.respone.UserIdentityRespone;
import com.example.demo.service.UserIdentityService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/useridentity")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserIdentityController {

	UserIdentityService userIdentityService;

	@PostMapping("/token")
	public LoginRespone generateToken(@RequestBody LoginRequest request) {

//		return ApiRespone.<LoginRespone>builder().result().build();
		return userIdentityService.getUserIdentity(request);
	}

	@PostMapping("/login")
	public ApiRespone<LoginRespone> login(@RequestBody LoginRequest request) {

//		return ApiRespone.<LoginRespone>builder().result().build();
		LoginRespone loginRespone = userIdentityService.getUserIdentity(request);
 
		return ApiRespone.<LoginRespone>builder().result(loginRespone).build();
	}

	@PostMapping("/createUserIdentity")
	public ApiRespone<UserIdentityRespone> createUserIdentity(@RequestBody UserIdentityCreationRequest request) {
		return ApiRespone.<UserIdentityRespone>builder().result(userIdentityService.createUserIdentity(request))
				.build();
	}

	@GetMapping("/decodeToken1")
	public String decodeToken1(@RequestHeader("Authorization") String authorizationHeader) {
		String token = authorizationHeader.substring(7);

		String idUserProfile = userIdentityService.getScopeFromToken(token);
		return idUserProfile;
	}

	@GetMapping("/decodeToken")
	public String decodeToken(@RequestParam String authorizationHeader) {
//		String token = authorizationHeader.substring(7);

		String idUserProfile = userIdentityService.getScopeFromToken(authorizationHeader);
		return idUserProfile;
	}

}
