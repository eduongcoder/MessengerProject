package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
	USER_IDENTITY_UNKNOW_ERROR(2000, "User identity unknow error"), USER_IDENTITY_EXISTS(2001, "User identity exists"),
	USER_IDENTITY_NOT_EXISTS(2002, "User identity not exists"),USER_IDENTITY_PASSWORD_NOT_CORRECT(2003,"User identity password not correct") ;

	private int code;
	private String message;

	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
