package com.example.demo.model;


import com.example.demo.model.bought.Bought;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoneyFlow extends PersistentEntity {
    @ManyToOne
    private Bought bought;
    private LocalDate date;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private FlowType flowType;
    @ManyToOne
    private User user;
}
