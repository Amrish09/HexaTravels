package com.hexa.dao;

/**
 * @author Srilatha
 * @author Durga
 *         <p>
 * 		this class is for user defined exception
 *         </p>
 */
public class UserException extends Exception {

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

}
