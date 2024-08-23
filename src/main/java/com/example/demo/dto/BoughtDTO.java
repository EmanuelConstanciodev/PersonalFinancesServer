package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BoughtDTO {
  private String description;

  private Long categoryId;

  private LocalDate date;

  private Double amount;

  private Long userId;

  private Integer installments;

  private Long cardId;
}
