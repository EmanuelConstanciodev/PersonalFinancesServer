package com.example.demo.model.bought;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CardInterface {
  public LocalDate getNextClosingDate(LocalDate date);
  public LocalDate getNextExpirationDate(LocalDate date);
}
