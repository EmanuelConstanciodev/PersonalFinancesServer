package com.example.demo.model.bought;

import java.time.LocalDate;
import java.time.YearMonth;

public class HSBC implements Card {

  @Override
  public LocalDate getNextClosingDate(LocalDate date) {
    date.getMonth().getY;
    YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
    LocalDate closingDate = getClosingDateOfAMonth(yearMonth);
    //PRIMER JUEVES SI TIENE 3 O MAS DIAS HABILES ANTES
    // SI NO, SEGUNDO JUEVES
    return null;
  }

  private LocalDate getClosingDateOfAMonth(YearMonth yearMonth) {
    for (int i = 0 ; i < 7; i++) {

    }
    yearMonth.atDay()
  }

  @Override
  public LocalDate getNextExpirationDate(LocalDate date) {
    return null;
  }
}
