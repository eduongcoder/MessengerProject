package com.example.demo.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.UserIdentityCreationRequest;
import com.example.demo.dto.respone.LoginRespone;
import com.example.demo.dto.respone.UserIdentityRespone;
import com.example.demo.entity.UserIdentity;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserIdentityRepository;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserIdentityService {

	UserMapper userMapper;
	UserIdentityRepository userIdentityRepository;

	@NonFinal
	@Value("${app.security.signer-key}")
	private String signerKey;

	@NonFinal
	@Value("${app.security.valid-duration}")
	private long VALID_DURATION;

	PasswordEncoder passwordEncoder;

	public UserIdentityRespone createUserIdentity(UserIdentityCreationRequest request) {
		if (userIdentityRepository.existsByEmail(request.getEmail())) {
			throw new AppException(ErrorCode.USER_IDENTITY_EXISTS);
		}
		UserIdentity userIdentity = userMapper.toUserIdentity(request);

		userIdentity.setPassword(passwordEncoder.encode(request.getPassword()));

		userIdentity = userIdentityRepository.save(userIdentity);
		return userMapper.toUserIdentityRespone(userIdentity);
	}

	public String generateToken(UserIdentity userIdentity) {
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

		JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject("Duong").issueTime(new Date())
				.expirationTime(new Date(Instant.now().plus(VALID_DURATION, ChronoUnit.SECONDS).toEpochMilli()))
				.jwtID(UUID.randomUUID().toString()).claim("scope","id userProfileNhen" ).build();

		Payload payload = new Payload(jwtClaimsSet.toJSONObject());

		JWSObject jwsObject = new JWSObject(header, payload);
		try {
			jwsObject.sign(new MACSigner(signerKey.getBytes()));
			return jwsObject.serialize();
		} catch (Exception e) {
			log.info("Cannot create token " + e.toString());
			throw new RuntimeException(e);
		}

	}

	public String decodeToken() {
		var authentication = SecurityContextHolder.getContext();
			
		
		if (authentication == null) {
			return "Không tìm thấy Authentication trong SecurityContext";
		} else
			return authentication.toString();
	}
	
	public  String getScopeFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
            
            return claimsSet.getStringClaim("scope");
        } catch (Exception e) {
            throw new AppException(ErrorCode.DECODE_TOKEN_ERROR);
        }
    }


	public LoginRespone getUserIdentity(LoginRequest request) {
		var userIdentity = userIdentityRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new AppException(ErrorCode.USER_IDENTITY_NOT_EXISTS));
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

		boolean isMatches = passwordEncoder.matches(request.getPassword(), userIdentity.getPassword());

		if (!isMatches) {
			throw new AppException(ErrorCode.USER_IDENTITY_PASSWORD_NOT_CORRECT);

		}
		var token = generateToken(userIdentity);

		return LoginRespone.builder().token(token).authenticated(isMatches).build();

	}

//	private String buildScope(UserIdentity userIdentity) {
//		StringJoiner stringJoiner=new StringJoiner(" ");
//		if (!CollectionUtils.isEmpty(userIdentity.get)) {
//			
//		}
//	}
}
