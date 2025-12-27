package com.rent.bff.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rent.bff.dto.ErrorResponse;

/**
 * Description: this class is responsible for TODO
 * vikas
 * @created on 27 Dec 2025
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(WebBffException.class)
	public ResponseEntity<ErrorResponse> handleWebBffException(WebBffException ex) {

		ErrorResponse response = new ErrorResponse();
		response.setMessage(ex.getMessage());
		response.setErrorCode(ex.getErrorCode());
		response.setStatus(ex.getStatus());
		response.setTimestamp(ex.getTimestamp().toString());

		return ResponseEntity.status(ex.getStatus()).body(response);
	}
}