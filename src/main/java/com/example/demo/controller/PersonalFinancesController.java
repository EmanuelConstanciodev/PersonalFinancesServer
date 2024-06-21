package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.OutFlow;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.services.OutFlowService;
import com.example.demo.utils.GenericResponseUtils;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.geom.GeneralPath;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonalFinancesController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OutFlowService outFlowService;

    @PostMapping("/createCategory")
    private ResponseEntity<PersonalFinancesGenericResponse> createCategory(@RequestBody Category category) {

        Category responseCategory;
        try {
            responseCategory = categoryService.createCategory(category);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(responseCategory), HttpStatus.OK);
    }


    @DeleteMapping("/deleteCategory/{id}")
    private ResponseEntity<PersonalFinancesGenericResponse> deleteCategory(@PathVariable Integer id) {

        try {
            categoryService.deleteCategory(id);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getCategories")
    private ResponseEntity<PersonalFinancesGenericResponse> getCategories() {
        List<Category> categoryList = categoryService.getCategories();
        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(categoryList), HttpStatus.OK);
    }


    @GetMapping("/getCategory/{id}")
    private ResponseEntity<PersonalFinancesGenericResponse> getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse("Category not found"), HttpStatus.NOT_FOUND));

    }

    @PostMapping("/createOutFlow")
    private ResponseEntity<PersonalFinancesGenericResponse> createOutFlow(@RequestBody OutFlow outFlow) {
        OutFlow responseOutFlow;
        try {
            responseOutFlow = outFlowService.createOutFlow(outFlow);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(responseOutFlow), HttpStatus.OK);
    }

//    @PutMapping("/editCategory/{id}")
//    private ResponseEntity<PersonalFinancesController> editCategory(@PathVariable Integer id, @RequestBody Category category) {
//
////        responseCategory = categoryService.editCategory(category);
//
//
////            return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse());
//
////            return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse("Category not found"), HttpStatus.NOT_FOUND);
//
//
//    }


//    @DeleteMapping("/deleteCategory/{categoryId}")
//    private ResponseEntity<PersonalFinancesGenericResponse> deleteCategory (@PathVariable Long categoryId) {
//
//    }
}
