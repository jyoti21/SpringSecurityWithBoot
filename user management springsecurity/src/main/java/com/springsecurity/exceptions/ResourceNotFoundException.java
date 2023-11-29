package com.springsecurity.exceptions;

public class ResourceNotFoundException extends RuntimeException {
  /** */
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException() {
    super("This resource is not found.");
  }
}
