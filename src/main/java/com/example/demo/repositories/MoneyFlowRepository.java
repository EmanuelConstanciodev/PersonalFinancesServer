package com.example.demo.repositories;

import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;

@Repository
public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, Long> {
  List<MoneyFlow> findAllByUser(User user);

  @Query("SELECT SUM(m.amount) FROM MoneyFlow m WHERE FUNCTION('YEAR', m.date) = :year AND FUNCTION('MONTH', m.date) = :month AND m.category = :category AND m.user = :user")
  Double getSumAmountOfAYearMonthCategoryAndUser(@Param("year") int year,
                                                 @Param("month") int month,
                                                 @Param("category") Category category,
                                                 @Param("user") User user);
}
