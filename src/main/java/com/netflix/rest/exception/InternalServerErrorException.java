package com.netflix.rest.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.netflix.rest.dto.ErrorDto;

/**
 * The Class InternalServerErrorException.
 */
public class InternalServerErrorException extends NetflixException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6870732210014274010L;

	/**
	 * Instantiates a new internal server error exception.
	 *
	 * @param message the message
	 */
	public InternalServerErrorException(final String message) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}

	/**
	 * Instantiates a new internal server error exception.
	 *
	 * @param message the message
	 * @param data the data
	 */
	public InternalServerErrorException(final String message, final ErrorDto data) {
		super(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
