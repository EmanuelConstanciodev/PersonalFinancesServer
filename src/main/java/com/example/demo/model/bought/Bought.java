package com.example.demo.model.bought;

import com.example.demo.model.MoneyFlow;
import com.example.demo.model.PersistentEntity;
import com.example.demo.model.User;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class Bought extends PersistentEntity {

    private Category category;

    private LocalDate date;

    private PaymentMethod paymentMethod;

    private Double amount;

    private User user;

    public List<MoneyFlow> generateAsociatedMoneyFlows() {
        return paymentMethod.getAsociatedMoneyFlows(this);
    }
}
