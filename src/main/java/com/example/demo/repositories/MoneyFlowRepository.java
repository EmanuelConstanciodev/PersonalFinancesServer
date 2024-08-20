package com.example.demo.repositories;

import com.example.demo.model.MoneyFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, Long> {
}
