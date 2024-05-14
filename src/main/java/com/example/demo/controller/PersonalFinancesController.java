package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonalFinancesController {
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/createCategory")
    private void createCategory (@RequestBody Category category) {
        categoryRepository.save(category);

    }
}
