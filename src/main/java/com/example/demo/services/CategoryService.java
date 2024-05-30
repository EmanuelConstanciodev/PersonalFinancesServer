package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }
}
