package com.cardapio.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException (Long id) {
		super("Resource not found. Id " + id);
	}
}
