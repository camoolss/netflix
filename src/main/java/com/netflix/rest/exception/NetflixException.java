package com.netflix.rest.exception;

import java.util.ArrayList;
import java.util.List;

import com.netflix.rest.dto.ErrorDto;

/**
 * The Class NetflixException.
 */
public abstract class NetflixException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7482635401716007171L;

	/** The code. */
	private final int code;

	/** The error list. */
	private final List<ErrorDto> errorList = new ArrayList<>();

	/**
	 * Instantiates a new netflix exception.
	 *
	 * @param code the code
	 * @param message the message
	 */
	public NetflixException(final int code, final String message) {
		super(message);
		this.code = code;
	}

	/**
	 * Instantiates a new netflix exception.
	 *
	 * @param code the code
	 * @param message the message
	 * @param errorList the error list
	 */
	public NetflixException(final int code, final String message, final List<ErrorDto> errorList) {
		super(message);
		this.code = code;
		this.errorList.addAll(errorList);
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Gets the error list.
	 *
	 * @return the error list
	 */
	public List<ErrorDto> getErrorList() {
		return errorList;
	}
}