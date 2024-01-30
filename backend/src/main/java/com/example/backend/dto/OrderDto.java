package com.example.backend.dto;

import com.example.backend.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDto {
    List<Long>products;
}
