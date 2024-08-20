package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;


  public User obtainUserByEmail(String userEmail) {
    return userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("No hay usuario con el mail dado"));
  }
}
