package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByName(String name);

    Boolean existsCategoriesByName(String name);

    List<Category> findAllByUser(User user);

}
