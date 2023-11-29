package com.springsecurity.exceptions;

import java.util.List;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ExceptionResponse processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		ExceptionResponse dto = getErrorResponse(Errors.BAD_REQUEST_EXCEPTION);
		for (FieldError error : fieldErrors) {
			dto.add(error.getObjectName(), error.getField(), error.getCode());
		}
		StringBuilder fields = new StringBuilder();
		fieldErrors.stream().forEach(x -> fields.append(x.getField()));
		log.info("Method Argument Not Valid for fields " + fields.toString());
		return dto;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public ExceptionResponse notFound(ResourceNotFoundException ex) {
		log.info("Expected resource not found. ");
		return getErrorResponse(Errors.RESOURCE_NOT_FOUND);
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ExceptionResponse badRequest(BadRequestException ex) {
		log.info("Bad request. ");
		return getExceptionResponse(ex);
	}
	private ExceptionResponse getErrorResponse(Errors error) {
		return ExceptionResponse.builder().type(error.getType()).status(error.getStatus().value())
				.message(error.getMessage()).build();
	}

	private ExceptionResponse getExceptionResponse(Exception exception) {
		return ExceptionResponse.builder().type("Invalid request").status(HttpStatus.BAD_REQUEST.value())
				.message(exception.getMessage()).build();
	}
}
