package com.hexa.dao;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		this class is for user defined exception
 *         </p>
 */
public class InvalidException extends Exception {

	public InvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidException(String message) {
		super(message);

	}
}
