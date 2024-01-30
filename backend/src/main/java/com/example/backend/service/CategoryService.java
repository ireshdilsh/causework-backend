package com.example.backend.service;

import com.example.backend.dto.CategoryDto;
import com.example.backend.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);

    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category updateCategory(CategoryDto categoryDto, Long id);
}
