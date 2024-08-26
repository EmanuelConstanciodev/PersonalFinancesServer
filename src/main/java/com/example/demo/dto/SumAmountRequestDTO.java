package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.YearMonth;

@Data
@AllArgsConstructor
@Builder
public class SumAmountRequestDTO {
  private Long categoryId;
  private YearMonth yearMonth;
}
