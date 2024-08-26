package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class IncomeDTO {
  private String description;

  private Long categoryId;

  private LocalDate date;

  private Double amount;

  private Long userId;
}
