package com.example.demo.services;

import com.example.demo.exceptions.CardNotFoundException;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.model.bought.Card;
import com.example.demo.model.bought.Category;
import com.example.demo.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
  @Autowired
  private CardRepository cardRepository;

  public Card getCardById(Long id) {
    return cardRepository.findById(id)
        .orElseThrow(() -> new CardNotFoundException());
  }
}
