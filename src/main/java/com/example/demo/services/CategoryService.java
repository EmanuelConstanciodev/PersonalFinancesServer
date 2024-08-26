package com.example.demo.services;

import com.example.demo.config.Converter;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import com.example.demo.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        if (categoryRepository.existsCategoriesByName(category.getName())) {
            throw new RuntimeException(category.getName());
        }
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryNotFoundException());
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> getCategoriesDTOOfAnUser(User user) {
        return getCategoriesOfAnUser(user)
            .stream()
            .map(category -> Converter.convertToDTO(category))
            .collect(Collectors.toList());
    }

    public List<Category> getCategoriesOfAnUser(User user) {
        return categoryRepository.findAllByUser(user);
    }

}