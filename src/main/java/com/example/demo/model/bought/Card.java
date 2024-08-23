package com.example.demo.model.bought;

import com.example.demo.model.PersistentEntity;
import com.example.demo.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Card extends PersistentEntity implements CardInterface {
  private String name;
  private LocalDate actualClosingDate;
  private LocalDate actualExpirationDate;
  @ManyToOne
  private User user;

  @Override
  public LocalDate getNextClosingDate(LocalDate date) {
    return !date.isBefore(actualClosingDate) ?
      LocalDate.of(date.plusMonths(1).getYear(),date.plusMonths(1).getMonth(),1) :
      actualClosingDate;
  }

  @Override
  public LocalDate getNextExpirationDate(LocalDate date) {
    return actualExpirationDate;
  }
}
