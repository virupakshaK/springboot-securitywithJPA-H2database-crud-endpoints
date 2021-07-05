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
public class EmptyInputExecption extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErrorInfo errorInfo;
	public EmptyInputExecption(int errorCode, String errorMessage){
		this.errorInfo = new ErrorInfo(errorMessage, errorCode);
	}
	
	
	
}
