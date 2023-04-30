package com.neuro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neuro.constants.ApplicationConstants;
import com.neuro.response.BaseExceptionResponse;

@ControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<BaseExceptionResponse> resourceNotFound(ResourceNotFoundException exception,
			WebRequest request) {
		return new ResponseEntity<BaseExceptionResponse>(buildResponse(HttpStatus.NOT_FOUND, exception, request),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<BaseExceptionResponse> resourceAlreadyExists(ResourceAlreadyExistsException exception,
			WebRequest request) {
		return new ResponseEntity<BaseExceptionResponse>(buildResponse(HttpStatus.CONFLICT, exception, request),
				HttpStatus.CONFLICT);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BaseExceptionResponse> customException(BadRequestException exception, WebRequest request) {
		return new ResponseEntity<BaseExceptionResponse>(buildResponse(HttpStatus.BAD_REQUEST, exception, request),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public final ResponseEntity<BaseExceptionResponse> handleMissingRequestHeaderException(
			MissingRequestHeaderException exception, WebRequest request) {
		BaseExceptionResponse response = buildResponse(HttpStatus.BAD_REQUEST, exception, request);
		response.setErrorMessage(ApplicationConstants.ERROR_MSG_MISSING_MANDATORY_PARAMETERS);
		return new ResponseEntity<BaseExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	private BaseExceptionResponse buildResponse(HttpStatus status, Exception exception, WebRequest webRequest) {
		BaseExceptionResponse response = new BaseExceptionResponse();
		response.setStatus(status.value());
		response.setErrorCode(status.name());
		response.setErrorMessage(exception.getMessage());
		return response;
	}
}
