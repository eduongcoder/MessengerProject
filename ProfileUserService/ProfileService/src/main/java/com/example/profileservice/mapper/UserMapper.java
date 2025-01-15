package com.example.profileservice.mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles",ignore = true)
    User toUser(UserRequest request);
    @Mapping(source = "iduser", target = "id") // Ánh xạ idMaterial của entity với id của DTO
    UserResponse toUserResponse(User user);
    @Mapping(target = "roles",ignore = true)
    void updateUser(@MappingTarget User user, User_Update update);
}
