package com.guan.exceptions;


public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8790211652911971729L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
}