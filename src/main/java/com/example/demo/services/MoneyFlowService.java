package com.example.demo.services;


import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.repositories.MoneyFlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyFlowService {
  @Autowired
  private MoneyFlowRepository moneyFlowRepository;

  public List<MoneyFlow> getMoneyFlowsOfAnUser(User user) {
    return moneyFlowRepository.findAllByUser(user);
  }

//    @Autowired
//    private final OutFlowRepository outFlowRepository;

//    public OutFlow createOutFlow(OutFlow outFlow){
//        return outFlowRepository.save(outFlow);
//    }
}
