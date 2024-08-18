package com.example.demo.repositories;

import com.example.demo.model.bought.Bought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoughtRepository extends JpaRepository<Bought, Long> {
}
