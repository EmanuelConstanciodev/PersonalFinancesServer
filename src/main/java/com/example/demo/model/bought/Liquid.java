package com.example.demo.model.bought;

import com.example.demo.model.FlowType;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.PersistentEntity;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("LIQUID")
public class Liquid extends PaymentMethod {

    @Override
    public List<MoneyFlow> getAsociatedMoneyFlows(Bought bought) {
        return Collections.singletonList(MoneyFlow.builder()
            .flowType(FlowType.OUT_FLOW)
            .amount(bought.getAmount())
            .date(bought.getDate())
            .bought(bought)
            .build());
    }

}
