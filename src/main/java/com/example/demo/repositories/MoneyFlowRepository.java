package com.example.demo.repositories;

import com.example.demo.model.MoneyFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, Long> {
}
