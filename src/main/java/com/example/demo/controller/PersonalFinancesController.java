package com.example.demo.controller;

import com.example.demo.config.Converter;
import com.example.demo.dto.*;
import com.example.demo.model.MoneyFlow;
import com.example.demo.model.User;
import com.example.demo.model.bought.Card;
import com.example.demo.model.bought.Category;
import com.example.demo.services.*;
import org.hibernate.sql.ast.tree.expression.Summarization;
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
    CardService cardService;

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
    private ResponseEntity<List<CategoryDTO>> getCategories(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        List<CategoryDTO> categoryList = categoryService.getCategoriesDTOOfAnUser(user);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/cards")
    private ResponseEntity<List<CardDTO>> getCards(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        List<CardDTO> cardList = cardService.getCards(user);
        return new ResponseEntity<>(cardList, HttpStatus.OK);
    }

    @PostMapping("/bought")
    public ResponseEntity<Void> createBought (@RequestBody BoughtDTO boughtDTO, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        boughtService.saveBoughtAndGenerateMoneyFlows(boughtDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/income")
    public ResponseEntity<Void> createIncome (@RequestBody IncomeDTO incomeDTO, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        moneyFlowService.createInFlow(incomeDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
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

    @GetMapping("/sumAmount")
    public ResponseEntity<SumAmountResponseDTO> getSumAmount(@RequestBody SumAmountRequestDTO sumAmountRequestDTO, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.obtainUserByEmail(userDetails.getUsername());
        SumAmountResponseDTO sumAmountResponseDTO = SumAmountResponseDTO.builder()
            .sumAmount(moneyFlowService.getSumAmountOfAYearMonthCategoryAndUser(sumAmountRequestDTO, user))
            .build();
        return new ResponseEntity<>(sumAmountResponseDTO, HttpStatus.OK);
    }
}
