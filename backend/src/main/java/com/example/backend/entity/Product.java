package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Column(nullable = true)
    private Integer qty;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore //to prevent contineous loading / circular dependency error
    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders = new HashSet<>();
}
