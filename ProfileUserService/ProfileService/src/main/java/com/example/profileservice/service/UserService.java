package com.example.profileservice.service;

import com.example.profileservice.DTO.UserDto;
import com.example.profileservice.entity.User;
import com.example.profileservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository; // Repository để thao tác với dữ liệu

    /**
     * Đăng ký người dùng mới.
     *
     * @param userDto Thông tin người dùng cần đăng ký
     * @return User Đối tượng người dùng đã được lưu
     * @throws IllegalArgumentException Nếu username hoặc email đã tồn tại
     */
    public User registerUser(User userDto) {
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
        newUser.setIsactive(true); // Mặc định là active
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        // Lưu người dùng vào cơ sở dữ liệu
        User savedUser = userRepository.save(newUser);

        log.info("Người dùng {} đã được đăng ký thành công!", newUser.getUsername());
        return savedUser;
    }
}

