package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class CardDTO {
  private Long id;
  private String name;
  private LocalDate actualClosingDate;
  private LocalDate actualExpirationDate;
}
