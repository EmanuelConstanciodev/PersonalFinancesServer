package com.example.demo.model.bought;

import com.example.demo.model.FlowType;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.PersistentEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("CREDIT")
public class Credit extends PaymentMethod {
    private Integer installments;
    @Transient
    private Card card;

    @Override
    public List<MoneyFlow> getAsociatedMoneyFlows(Bought bought) {
        List<MoneyFlow> moneyFlows = new ArrayList<>();
        Double amountPerInstallment = bought.getAmount() / installments;

        LocalDate nextMoneyFlowDate = card.getNextClosingDate(bought.getDate());
        for(Integer i = 0; i < installments; i++) {
            moneyFlows.add(MoneyFlow.builder()
                .date(nextMoneyFlowDate)
                .flowType(FlowType.OUT_FLOW)
                .amount(amountPerInstallment)
                .bought(bought)
                .user(bought.getUser())
                .build());
            nextMoneyFlowDate = card.getNextClosingDate(nextMoneyFlowDate);
        }

        return moneyFlows;
    }
}
