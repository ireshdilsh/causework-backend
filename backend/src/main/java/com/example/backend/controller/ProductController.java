package com.example.backend.controller;

import com.example.backend.dto.ProductDto;
import com.example.backend.entity.Product;
import com.example.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/add/product")
    private ResponseEntity<Product>createProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.status(200).body(productService.createProduct(productDto));
    }

    @GetMapping("/get/all/products")
    private ResponseEntity<List<Product>>getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/get/product/id/{id}")
    private ResponseEntity<Product>getProductById(@PathVariable Long id){
        return ResponseEntity.status(200).body(productService.getProductById(id));
    }

    @PutMapping("/update/product/id/{id}")
    private ResponseEntity<Product>updateProduct(@RequestBody ProductDto productDto,@PathVariable Long id){
        return ResponseEntity.status(200).body(productService.updateProduct(productDto,id));
    }
    @GetMapping("/get/product/by/category/id/{id}")
    private ResponseEntity<List<Product>>getProductByCategoryId(@PathVariable Long id){
        return ResponseEntity.status(200).body(productService.getProductByCategoryId(id));
    }
}
