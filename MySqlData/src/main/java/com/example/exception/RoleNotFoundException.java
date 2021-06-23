package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
