package com.example.demo.model;

import com.example.demo.model.bought.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.YearMonth;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyRegister extends PersistentEntity {
  @ManyToOne
  private User user;
  private YearMonth yearMonth;
  @ManyToOne
  private Category category;
  private Double amount;
}
