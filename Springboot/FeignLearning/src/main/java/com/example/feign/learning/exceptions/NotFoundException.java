package com.example.feign.learning.exceptions;

public class NotFoundException extends Exception {

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }

  @Override
  public String toString() {
    return "NotFoundException: " + getMessage();
  }

}