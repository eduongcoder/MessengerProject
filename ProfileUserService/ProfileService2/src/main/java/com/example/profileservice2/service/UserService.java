package com.example.profileservice2.service;

import com.example.profileservice2.DTO.Request.UserIdentityCreationRequest;
import com.example.profileservice2.DTO.Request.UserRequest;
import com.example.profileservice2.DTO.Response.ApiRespone;
import com.example.profileservice2.DTO.Response.UserIdentityRespone;
import com.example.profileservice2.DTO.Response.UserReponse;
import com.example.profileservice2.entity.User;
import com.example.profileservice2.mapper.UserMapper;
import com.example.profileservice2.openfeign.IdentityServiceClient;
import com.example.profileservice2.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
	IdentityServiceClient authServiceClient;

	UserRepository userRepository; // Repository để thao tác với dữ liệu

	UserMapper userMapper;
	
	

	@Transactional
	public User registerUser(UserRequest userDto) {
		// Kiểm tra username hoặc email trùng lặp

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
// Gọi Identity Service để tạo UserIdentity
		UserIdentityCreationRequest identityRequest = new UserIdentityCreationRequest();
		identityRequest.setIdUserProfile(savedUser.getId());
		identityRequest.setEmail(savedUser.getEmail());
		identityRequest.setPassword(savedUser.getPassword());

		try {
			ApiRespone<UserIdentityRespone> response = authServiceClient.createUserIdentity(identityRequest);
			System.out.println("Identity Service Response: " + response.getResult().getEmail());
		} catch (Exception e) {
			System.err.println("Lỗi khi gọi Identity Service: " + e.getMessage());
			return null;
		}

		// log.info("Người dùng {} đã được đăng ký thành công!", newUser.getUsername());
		return savedUser;
	}

	public UserReponse getUserProfile(String token) {

		String userId = authServiceClient.decodeToken(token);
		User user = userRepository.findById((userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

//		if (userRepository.existsById(userId)) {

//			User user=userRepository.findById(userId).get();
		UserReponse userReponse = userMapper.toUserReponse(user);
		userReponse.setRoom();
		return userReponse;
//		}
	
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

}