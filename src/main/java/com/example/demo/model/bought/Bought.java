package com.example.demo.model.bought;

import com.example.demo.model.FlowType;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.PersistentEntity;
import com.example.demo.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bought extends PersistentEntity {
    private String description;

    @ManyToOne
    private Category category;

    private LocalDate date;

    private Double amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Card card;

    private Integer installments;

    public List<MoneyFlow> generateAsociatedMoneyFlows() {
        return installments.equals(0) ? this.generateLiquidMoneyFlow() : this.generateCreditMoneyFlow();
    }

    private List<MoneyFlow> generateCreditMoneyFlow() {
        List<MoneyFlow> moneyFlows = new ArrayList<>();
        Double amountPerInstallment = amount / installments;

        LocalDate nextMoneyFlowDate = card.getNextClosingDate(date);
        for(Integer i = 0; i < installments; i++) {
            moneyFlows.add(MoneyFlow.builder()
                .date(nextMoneyFlowDate)
                .flowType(FlowType.OUT_FLOW)
                .amount(-amountPerInstallment)
                .bought(this)
                .user(user)
                .build());
            nextMoneyFlowDate = card.getNextClosingDate(nextMoneyFlowDate);
        }

        return moneyFlows;
    }

    private List<MoneyFlow> generateLiquidMoneyFlow() {
        return Collections.singletonList(MoneyFlow.builder()
            .flowType(FlowType.OUT_FLOW)
            .amount(-amount)
            .date(date)
            .bought(this)
            .build());
    }
}
