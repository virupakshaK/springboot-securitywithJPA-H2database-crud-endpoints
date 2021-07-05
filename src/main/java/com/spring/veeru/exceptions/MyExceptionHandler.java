package com.spring.veeru.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author virupaksha.kuruva
 *
 */
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value=EmptyInputExecption.class)
	public ResponseEntity<ErrorInfo> handleNotInputException(EmptyInputExecption emptyInputExecption){
		
		return new ResponseEntity<ErrorInfo>(emptyInputExecption.getErrorInfo(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleUserNotFoundException(UserNotFoundException emptyInputExecption){
		return new ResponseEntity<ErrorInfo>(emptyInputExecption.getErrorInfo(), HttpStatus.NOT_FOUND);
	}
	
}
