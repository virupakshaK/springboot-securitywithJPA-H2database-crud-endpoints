package com.spring.veeru.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author virupaksha.kuruva
 *
 */
@Getter
@Setter
@ToString
public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorInfo errorInfo;

	public UserNotFoundException(int errorCode, String errorMessage) {
		super();
		this.errorInfo = new ErrorInfo(errorMessage, errorCode);
	}

	public UserNotFoundException() {
		super();

	}

}
