package com.example.demo.repositories;

import com.example.demo.model.Category;
import com.example.demo.model.OutFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutFlowRepository extends JpaRepository<OutFlow, Integer > {


}


