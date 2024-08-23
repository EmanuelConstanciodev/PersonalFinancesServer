package com.example.demo.services;

import com.example.demo.dto.BoughtDTO;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Bought;
import com.example.demo.model.bought.Card;
import com.example.demo.model.bought.Category;
import com.example.demo.repositories.BoughtRepository;
import com.example.demo.repositories.MoneyFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoughtService {
  @Autowired
  private BoughtRepository boughtRepository;

  @Autowired
  private MoneyFlowRepository moneyFlowRepository;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private CardService cardService;

  public void saveBoughtAndGenerateMoneyFlows(BoughtDTO boughtDTO, User user) {
    Card card = cardService.getCardById(boughtDTO.getCardId());
    Category category = categoryService.getCategoryById(boughtDTO.getCategoryId());

    Bought bought = Bought.builder()
        .description(boughtDTO.getDescription())
        .category(category)
        .date(boughtDTO.getDate())
        .amount(boughtDTO.getAmount())
        .user(user)
        .card(card)
        .installments(boughtDTO.getInstallments())
        .build();

    boughtRepository.save(bought);

    List<MoneyFlow> moneyFlows = bought.generateAsociatedMoneyFlows();
    moneyFlows.forEach(moneyFlow -> moneyFlowRepository.save(moneyFlow));
  }
}
