package com.example.demo.model.bought;

import com.example.demo.model.MoneyFlow;
import jakarta.persistence.MappedSuperclass;

import java.util.List;

@MappedSuperclass
public interface PaymentMethodInterface {
    List<MoneyFlow> getAsociatedMoneyFlows(Bought bought);
}
