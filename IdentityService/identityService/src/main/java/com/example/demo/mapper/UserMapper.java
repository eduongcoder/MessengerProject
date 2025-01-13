package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.request.UserIdentityCreationRequest;
import com.example.demo.entity.UserIdentity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserIdentity toUserIdentity(UserIdentityCreationRequest request);
}
