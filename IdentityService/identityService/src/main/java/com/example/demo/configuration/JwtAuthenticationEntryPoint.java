package com.example.demo.configuration;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.demo.dto.respone.ApiRespone;
import com.example.demo.exception.ErrorCode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;

		response.setStatus(errorCode.getStatusCode().value());

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		ApiRespone<?> apiRespone = ApiRespone.builder().code(errorCode.getCode()).message(errorCode.getMessage())
				.build();
		ObjectMapper objectMapper=new ObjectMapper();
		
		response.getWriter().write(objectMapper.writeValueAsString(apiRespone));
		response.flushBuffer();
	
	}

}
