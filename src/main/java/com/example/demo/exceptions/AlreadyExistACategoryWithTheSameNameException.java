package com.example.demo.exceptions;

public class AlreadyExistACategoryWithTheSameNameException extends RuntimeException {
  public AlreadyExistACategoryWithTheSameNameException(String name) {
    super("The category with name " + name + " already exists");
  }
}
