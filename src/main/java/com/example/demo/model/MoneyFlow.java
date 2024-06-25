package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//@Entity
@Setter
@Getter
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class MoneyFlow extends PersistentEntity {
    @ManyToOne
    private Bought bought;

    private LocalDateTime dateTime;

    private Double amount;
}
