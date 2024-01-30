package com.example.backend.service.impl;

import com.example.backend.dto.CategoryDto;
import com.example.backend.entity.Category;
import com.example.backend.reposiory.CategoryRepository;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDto categoryDto) {

        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());

        return categoryRepository.save(category);

    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto, Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if (category != null) {

            category.setId(categoryDto.getId());
            category.setName(categoryDto.getName());

            return categoryRepository.save(category);
        }else {
            return null;
        }
    }
}
