package com.example.demo.services;


import com.example.demo.dto.IncomeDTO;
import com.example.demo.dto.SumAmountRequestDTO;
import com.example.demo.model.FlowType;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import com.example.demo.repositories.MoneyFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class MoneyFlowService {
  @Autowired
  private MoneyFlowRepository moneyFlowRepository;

  @Autowired
  private CategoryService categoryService;

  public List<MoneyFlow> getMoneyFlowsOfAnUser(User user) {
    return moneyFlowRepository.findAllByUser(user);
  }

  public void saveMoneyFlow (MoneyFlow moneyFlow) {
    moneyFlowRepository.save(moneyFlow);
  }

  public Double getSumAmountOfAYearMonthCategoryAndUser(YearMonth yearMonth, Category category, User user) {
    return moneyFlowRepository.getSumAmountOfAYearMonthCategoryAndUser(yearMonth.getYear(),yearMonth.getMonth().getValue(),category,user);
  }
  public Double getSumAmountOfAYearMonthCategoryAndUser(SumAmountRequestDTO sumAmountRequestDTO, User user) {
    Category category = categoryService.getCategoryById(sumAmountRequestDTO.getCategoryId());
    return moneyFlowRepository.getSumAmountOfAYearMonthCategoryAndUser(sumAmountRequestDTO.getYearMonth().getYear(), sumAmountRequestDTO.getYearMonth().getMonth().getValue(), category, user);
  }

  public void createInFlow(IncomeDTO incomeDTO, User user) {
    moneyFlowRepository.save(MoneyFlow.builder()
        .date(incomeDTO.getDate())
        .amount(incomeDTO.getAmount())
        .user(user)
        .flowType(FlowType.IN_FLOW)
        .build());
  }
}
