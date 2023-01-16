package com.user.service.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 3945216271133393559L;
//extra properties that you want to manage
	public UserException() {
		super("Resource not fount on server!!");
	}

	public UserException(String message) {
		super(message);
	}
}
