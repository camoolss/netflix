package com.netflix.rest.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.netflix.rest.dto.ErrorDto;

/**
 * The Class NotFoundException.
 */
public class NotFoundException extends NetflixException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6870732210014274010L;

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 */
	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 * @param data the data
	 */
	public NotFoundException(final String message, final ErrorDto data) {
		super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
}

