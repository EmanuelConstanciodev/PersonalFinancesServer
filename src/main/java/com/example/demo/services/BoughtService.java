package com.example.demo.services;

import com.example.demo.model.MoneyFlow;
import com.example.demo.model.bought.Bought;
import com.example.demo.repositories.BoughtRepository;
import com.example.demo.repositories.CategoryRepository;
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

  public void saveBoughtAndGenerateMoneyFlows(Bought bought) {
    boughtRepository.save(bought);
    List<MoneyFlow> moneyFlows = bought.generateAsociatedMoneyFlows();
    moneyFlows.forEach(moneyFlow -> moneyFlowRepository.save(moneyFlow));
  }
}
