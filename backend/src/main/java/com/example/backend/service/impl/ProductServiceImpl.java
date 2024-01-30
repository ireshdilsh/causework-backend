package com.example.backend.service.impl;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.Category;
import com.example.backend.entity.Product;
import com.example.backend.reposiory.CategoryRepository;
import com.example.backend.reposiory.ProductRepository;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();

        Category category=categoryRepository.findById(productDto.getCategoryid()).orElse(null);

        if (category != null) {
            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setQty(productDto.getQty());
            product.setCategory(category);

            return productRepository.save(product);
        }else {
            return null;
        }

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(ProductDto productDto, Long id) {

        //Category category=categoryRepository.findById(id).
        Product product=productRepository.findById(id).orElse(null);

        if (product != null) {

            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setQty(productDto.getQty());
            product.setCategory(product.getCategory());

            return productRepository.save(product);
        }else {
            return null;
        }
    }

    @Override
    public List<Product> getProductByCategoryId(Long id) {
        Category category=categoryRepository.findById(id).orElse(null);

        if (category != null) {
            return productRepository.findProductByCategory(category);
        }else {
            return null;
        }
    }

}
