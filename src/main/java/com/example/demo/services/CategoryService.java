package com.example.demo.services;

import com.example.demo.exceptions.AlreadyExistACategoryWithTheSameNameException;
import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        if (categoryRepository.existsCategoriesByName(category.getName())) {
            throw new AlreadyExistACategoryWithTheSameNameException(category.getName());
        }
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);

    }

    public Integer deleteCategory(Integer id) {

        categoryRepository.deleteById(id);
    }
}