package com.example.demo.model.bought;

import com.example.demo.model.FlowType;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.PersistentEntity;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
//@Entity
public class Liquid extends PersistentEntity implements PaymentMethod {

    @Override
    public List<MoneyFlow> getAsociatedMoneyFlows(Bought bought) {
        return Collections.singletonList(MoneyFlow.builder()
            .flowType(FlowType.OUT_FLOW)
            .amount(bought.getAmount())
            .dateTime(bought.getDate())
            .bought(bought)
            .build());
    }

}
