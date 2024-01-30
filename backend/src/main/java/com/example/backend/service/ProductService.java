package com.example.backend.service;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(ProductDto productDto);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(ProductDto productDto, Long id);


    List<Product> getProductByCategoryId(Long id);
}
