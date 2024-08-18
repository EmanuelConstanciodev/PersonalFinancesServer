package com.example.demo.model.bought;

import com.example.demo.model.MoneyFlow;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@MappedSuperclass
public interface PaymentMethod {
    List<MoneyFlow> getAsociatedMoneyFlows(Bought bought);
}
