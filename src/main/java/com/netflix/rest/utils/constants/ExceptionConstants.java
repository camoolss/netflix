package com.netflix.rest.utils.constants;

/**
 * The Class ExceptionConstants.
 */
public class ExceptionConstants {

	/** The Constant ERROR. */
	public static final String ERROR = "ERROR";

	/** The Constant MESSAGE_INEXISTENT_SEASON. */
	public static final String MESSAGE_INEXISTENT_SEASON = "SEASON INEXISTENT - Season does not exist";
	
	/** The Constant MESSAGE_INEXISTENT_CHAPTER. */
	public static final String MESSAGE_INEXISTENT_CHAPTER = "CHAPTER INEXISTENT - Chapter does not exist";

	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has ocurred";

	/**
	 * Instantiates a new exception constants.
	 */
	private ExceptionConstants() {
		throw new IllegalStateException("Utility Class");
	}

}
