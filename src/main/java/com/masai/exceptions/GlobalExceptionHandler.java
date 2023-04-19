package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception ce,WebRequest req) {
			
		MyErrorDetails errorDetails = new MyErrorDetails();
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(ce.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> notValidate(MethodArgumentNotValidException mav) {
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage("Validation Error");
		errorDetails.setDescription(mav.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException se, WebRequest req) {
		
		MyErrorDetails errorDetails = new MyErrorDetails();
		
		errorDetails.setTimestamp(LocalDateTime.now());
		errorDetails.setMessage(se.getMessage());
		errorDetails.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
		
	}

}
