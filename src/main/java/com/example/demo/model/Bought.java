package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bought extends PersistentEntity {

    private Category category;

    private LocalDateTime dateTime;

    private PaymentMethod paymentMethod;

    private Double amount;
}
