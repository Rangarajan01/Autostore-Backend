package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(Integer engineno) {
		super("Could not found the user with engineno "+engineno);
	}
}
