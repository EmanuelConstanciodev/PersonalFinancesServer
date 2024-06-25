package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
//@Entity
public class VisaCredit extends PersistentEntity implements PaymentMethod {
    @Override
    public List<OutFlow> getMoneyFlows(LocalDateTime dateTime, Double amount) {
        return List.of();
    }
}
