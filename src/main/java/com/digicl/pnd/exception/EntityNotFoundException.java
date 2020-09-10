package com.digicl.pnd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(Class<?> clazz, String message) {
		super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), message));
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + ": " + message;
	}
}
