package com.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(UserException ex){
		
		String message = ex.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).succes(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}

}
