package com.netflix.rest.response;

import java.io.Serializable;

/**
 * The Class NetflixResponse.
 *
 * @param <T> the generic type
 */
public class NetflixResponse<T> implements Serializable {

	/** The status. */
	private String status;
	
	/** The code. */
	private String code;
	
	/** The message. */
	private String message;
	
	/** The data. */
	private T data;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7302319210373510173L;

	/**
	 * Instantiates a new netflix response.
	 */
	public NetflixResponse() {
		super();
	}

	/**
	 * Instantiates a new netflix response.
	 *
	 * @param status the status
	 * @param code the code
	 * @param message the message
	 */
	public NetflixResponse(String status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	/**
	 * Instantiates a new netflix response.
	 *
	 * @param status the status
	 * @param code the code
	 * @param message the message
	 * @param data the data
	 */
	public NetflixResponse(String status, String code, String message, T data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

}