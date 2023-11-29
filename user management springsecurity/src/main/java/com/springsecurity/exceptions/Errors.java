package com.springsecurity.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Errors {

  BAD_REQUEST_EXCEPTION("Bad request.", HttpStatus.BAD_REQUEST, "Bad request"),
  RESOURCE_NOT_FOUND("Resource not found.", HttpStatus.NOT_FOUND, "Resource not found.");

  private final String type;
  private final HttpStatus status;
  private final String message;

  Errors(String type, HttpStatus status, String message) {
    this.type = type;
    this.status = status;
    this.message = message;
  }
}
