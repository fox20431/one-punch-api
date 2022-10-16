package com.hihusky.user.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException{

	public InvalidUsernameOrPasswordException(String message) {
		super("Invalid username or password!");
	}
	
}
