package com.bancounion.model.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import com.bancounion.model.ErrorObject;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleResourceNotFoundException(Exception ex) {
		ErrorObject eObject = new ErrorObject.ErrorObjectBuilder().status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage()).timestamp(LocalDateTime.now()).builder();
		return new ResponseEntity<>(eObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResponseStatusException ex) {
		ErrorObject eObject = new ErrorObject.ErrorObjectBuilder().status(HttpStatus.BAD_REQUEST.value())
				.message(ex.getMessage()).timestamp(LocalDateTime.now()).builder();
		return new ResponseEntity<>(eObject, HttpStatus.BAD_REQUEST);
	}
}
