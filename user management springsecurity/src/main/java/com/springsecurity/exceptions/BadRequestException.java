package com.springsecurity.exceptions;

public class BadRequestException extends RuntimeException {

  /** */
  private static final long serialVersionUID = 1L;

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {
    super("Bad Request.");
  }
}
