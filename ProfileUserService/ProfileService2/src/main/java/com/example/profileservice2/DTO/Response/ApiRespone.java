package com.example.profileservice2.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
//@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ApiRespone<T> {
	@Builder.Default
	int code=1000;
	String message;
	T result;
	public ApiRespone(String message) {
		this.message = message;
	}

	// Constructor 2: Nhận message và result
	public ApiRespone(String message, T result) {
		this.message = message;
		this.result = result;
	}

	// Constructor 3: Nhận message, result và mã code
	public ApiRespone(int code, String message, T result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public ApiRespone(String friendRequestSentSuccessfully, String pending, String requestId) {

	}
}
