package com.example.demo.repositories;

import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, Long> {
  List<MoneyFlow> findAllByUser(User user);
}
