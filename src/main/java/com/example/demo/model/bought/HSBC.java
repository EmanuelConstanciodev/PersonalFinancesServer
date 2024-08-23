package com.example.demo.model.bought;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class HSBC implements CardInterface {
  @Override
  public LocalDate getNextClosingDate(LocalDate date) {
    YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
    LocalDate closingDate = getClosingDateOfAYearMonth(yearMonth);
    return date.isBefore(closingDate) ? closingDate : getClosingDateOfAYearMonth(yearMonth.plusMonths(1));
  }

  private LocalDate getClosingDateOfAYearMonth(YearMonth yearMonth) {
    Integer businessDays = 0;
    for (int i = 1 ; i <= 8; i++) {
      LocalDate actualDate = yearMonth.atDay(i);
      DayOfWeek actualDayOfWeek = actualDate.getDayOfWeek();
      if (isBusinessDay(actualDayOfWeek)) {
        businessDays++;
      } else if (actualDayOfWeek.equals(DayOfWeek.THURSDAY) && businessDays >= 3) {
        return actualDate;
      }
    }
    return null;
  }

  private boolean isBusinessDay(DayOfWeek actualDayOfWeek) {
    return actualDayOfWeek.equals(DayOfWeek.MONDAY)
        || actualDayOfWeek.equals(DayOfWeek.TUESDAY)
        || actualDayOfWeek.equals(DayOfWeek.WEDNESDAY)
        || actualDayOfWeek.equals(DayOfWeek.THURSDAY)
        || actualDayOfWeek.equals(DayOfWeek.FRIDAY);
  }

  @Override
  public LocalDate getNextExpirationDate(LocalDate date) {
    return null;
  }
}
