package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.utils.GenericResponseUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.geom.GeneralPath;
import java.util.List;

@Controller
public class PersonalFinancesController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/createCategory")
    private ResponseEntity<PersonalFinancesGenericResponse> createCategory (@RequestBody Category category) {
        Category responseCategory;
        try {
            responseCategory = categoryService.createCategory(category);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(responseCategory), HttpStatus.OK);
    }

    @GetMapping("/getCategories")
    private ResponseEntity<PersonalFinancesGenericResponse> getCategories () {
        List<Category> categoryList = categoryService.getCategories();
        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(categoryList), HttpStatus.OK);
    }

//    @DeleteMapping("/deleteCategory/{categoryId}")
//    private ResponseEntity<PersonalFinancesGenericResponse> deleteCategory (@PathVariable Long categoryId) {
//
//    }
}
