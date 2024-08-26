package com.example.demo.config;

import com.example.demo.dto.CardDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.model.bought.Card;
import com.example.demo.model.bought.Category;

public class Converter {
  public static CategoryDTO convertToDTO(Category category) {
    return CategoryDTO.builder()
        .name(category.getName())
        .description(category.getDescription())
        .build();
  }
  public static CardDTO convertToDTO(Card card) {
    return CardDTO.builder()
        .id(card.getId())
        .name(card.getName())
        .actualClosingDate(card.getActualClosingDate())
        .actualExpirationDate(card.getActualExpirationDate())
        .build();
  }

}
