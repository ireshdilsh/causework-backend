package com.example.backend.controller;

import com.example.backend.dto.CategoryDto;
import com.example.backend.entity.Category;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add/category")
    private Category createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("get/all/category")
    private ResponseEntity<List<Category>>getAllCategory(){
        return ResponseEntity.status(200).body(categoryService.getAllCategory());
    }

    @GetMapping("get/category/id/{id}")
    private ResponseEntity<Category>getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(200).body(categoryService.getCategoryById(id));
    }
    @PutMapping("/update/Category/{id}")
    private ResponseEntity<Category>updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Long id){
        return ResponseEntity.status(200).body(categoryService.updateCategory(categoryDto,id));
    }
}
