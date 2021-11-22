package com.zensar.exception;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(value= {InvalidStockIdException.class})
	private ResponseEntity<Object> handleInvalidStockIdError(RuntimeException exception,
		WebRequest request) {
		// TODO Auto-generated method stub
		return handleExceptionInternal(exception, exception.toString(),new HttpHeaders(),
				HttpStatus.BAD_REQUEST,request);
	}
	

}
