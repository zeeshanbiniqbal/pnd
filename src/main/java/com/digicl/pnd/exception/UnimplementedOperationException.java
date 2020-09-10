package com.digicl.pnd.exception;

import org.springframework.util.StringUtils;

@SuppressWarnings("serial")
public class UnimplementedOperationException extends RuntimeException {

	public UnimplementedOperationException(Class<?> clazz, String message) {
		super(UnimplementedOperationException.generateMessage(clazz.getSimpleName(), message));
	}

	public UnimplementedOperationException(String message) {
		super(message);
	}

	private static String generateMessage(String entity, String message) {
		return StringUtils.capitalize(entity) + ": " + message;
	}
}
