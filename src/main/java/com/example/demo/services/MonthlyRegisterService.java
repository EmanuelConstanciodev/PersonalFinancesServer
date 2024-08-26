package com.example.demo.services;

import com.example.demo.model.MonthlyRegister;
import com.example.demo.repositories.MonthlyRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;

@Service
public class MonthlyRegisterService {
  @Autowired
  private UserService userService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private MoneyFlowService moneyFlowService;

  @Autowired
  private MonthlyRegisterRepository monthlyRegisterRepository;

  public void createMonthlyRegisters(YearMonth yearMonth) {
    userService.getAllUsers().forEach(user -> {
      categoryService.getCategoriesOfAnUser(user).forEach(category -> {
        Double amount = moneyFlowService.getSumAmountOfAYearMonthCategoryAndUser(yearMonth, category, user);
        monthlyRegisterRepository.save(MonthlyRegister.builder()
            .amount(amount)
            .user(user)
            .yearMonth(yearMonth)
            .category(category)
            .build());
      });
    });
  }
}
