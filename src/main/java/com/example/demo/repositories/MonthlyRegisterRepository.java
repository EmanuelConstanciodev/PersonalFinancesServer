package com.example.demo.repositories;

import com.example.demo.model.MonthlyRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MonthlyRegisterRepository extends JpaRepository<MonthlyRegister, Long> {

}
