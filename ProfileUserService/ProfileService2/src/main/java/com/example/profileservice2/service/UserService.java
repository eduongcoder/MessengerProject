package com.example.profileservice2.service;

import com.example.profileservice2.DTO.Request.UserRequest;
import com.example.profileservice2.DTO.Response.UserReponse;
import com.example.profileservice2.entity.User;
import com.example.profileservice2.mapper.UserMapper;
import com.example.profileservice2.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository; // Repository để thao tác với dữ liệu
    private final JwtUtil jwtUtil;
    public UserService(UserRepository userService) {
        this.userRepository = userService;
    }

    public User registerUser(UserRequest userDto) {
        // Kiểm tra username hoặc email trùng lặp
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại!");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email đã tồn tại!");
        }

        // Tạo mới đối tượng User
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword()); // Mã hóa mật khẩu nếu cần
        newUser.setAvatar(userDto.getAvatar());
        newUser.setPhonenumber(userDto.getPhonenumber());
        newUser.setIsactive(false); // Mặc định là active
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        // Lưu người dùng vào cơ sở dữ liệu
        User savedUser = userRepository.save(newUser);

        //log.info("Người dùng {} đã được đăng ký thành công!", newUser.getUsername());
        return savedUser;
    }

    public UserReponse getUserProfile(String token) {
        UUID userId = jwtUtil.extractUserId(token);
        User user = userRepository.findById((userId))
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toUserReponse(user);
    }

}