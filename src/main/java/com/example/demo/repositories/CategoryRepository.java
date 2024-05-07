package com.example.demo.repositories;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
  //TipoDatoRespuesta nombreMetodo(TipoDatoRequest nombreVariable) {
    //    LOGICA;
    //   return variableTipoDatoRespuesta;
    //}

    List<Category> findAllByName(String name);
}
