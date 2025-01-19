package com.example.profileservice2.mapper;

import com.example.profileservice2.DTO.Request.UserRequest;
import com.example.profileservice2.DTO.Response.UserReponse;
import com.example.profileservice2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequest userRequest);

    UserReponse toUserReponse(User user);


}

