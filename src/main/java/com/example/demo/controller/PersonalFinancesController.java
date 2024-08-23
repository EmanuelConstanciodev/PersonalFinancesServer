package com.example.demo.controller;

import com.example.demo.dto.BoughtDTO;
import com.example.demo.dto.MoneyFlowsOfABoughtResponseDTO;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Category;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PersonalFinancesController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BoughtService boughtService;

    @Autowired
    MoneyFlowService moneyFlowService;

    @Autowired
    UserService userService;

    @PostMapping("/category")
    private ResponseEntity<Category> createCategory(@RequestBody Category category, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        Category responseCategory;
        try {
            category.setUser(user);
            responseCategory = categoryService.createCategory(category);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(responseCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    private ResponseEntity<Void> deleteCategory(@PathVariable Long id) {

        try {
            categoryService.deleteCategory(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories")
    private ResponseEntity<List<Category>> getCategories(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        List<Category> categoryList = categoryService.getCategoriesOfAnUser(user);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);

    }

//    @PostMapping("/inFlow")
//    private ResponseEntity<PersonalFinancesGenericResponse> createOutFlow(@RequestBody OutFlow outFlow) {
//        OutFlow responseOutFlow;
//        try {
//            responseOutFlow = outFlowService.createOutFlow(outFlow);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//        return new ResponseEntity<>(GenericResponseUtils.personalFinancesGenericResponse(responseOutFlow), HttpStatus.OK);
//    }

    @PostMapping("/bought")
    public ResponseEntity<String> createBought (@RequestBody BoughtDTO boughtDTO, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        boughtService.saveBoughtAndGenerateMoneyFlows(boughtDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Compra guardada exitosamente");
    }


    @GetMapping("/moneyFlow/{boughtId}")
    public ResponseEntity<MoneyFlowsOfABoughtResponseDTO> getMoneyFlowsOfABought(@PathVariable Long boughtId) {

        return null;
    }

    @GetMapping("/moneyFlows")
    public ResponseEntity<List<MoneyFlow>> getMoneyFlowsOfABought(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        List<MoneyFlow> moneyFlowList = moneyFlowService.getMoneyFlowsOfAnUser(user);
        return new ResponseEntity<>(moneyFlowList, HttpStatus.OK);
    }

//    @PutMapping("/category/{id}")
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

}
