package com.springsecurity.exceptions;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {
  private int status;
  private String type;
  private String message;

  private List<FieldErrorVM> fieldErrors;

  public void add(String objectName, String field, String message) {
    if (fieldErrors == null) fieldErrors = new ArrayList<>();

    fieldErrors.add(new FieldErrorVM(objectName, field, message));
  }
  }

