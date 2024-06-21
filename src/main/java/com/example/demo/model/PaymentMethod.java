package com.example.demo.model;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.List;

@MappedSuperclass
public interface PaymentMethod {
    List<OutFlow> getMoneyFlows(LocalDateTime dateTime, Double amount);
}
