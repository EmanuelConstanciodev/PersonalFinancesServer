package com.example.demo.model.bought;

import java.time.LocalDate;

public class HSBC implements Card {

  @Override
  public LocalDate getNextClosingDate(LocalDate date) {
    //PRIMER JUEVES SI TIENE 3 O MAS DIAS HABILES ANTES
    // SI NO, SEGUNDO JUEVES
    return null;
  }

  @Override
  public LocalDate getNextExpirationDate(LocalDate date) {
    return null;
  }
}
