package com.example.backend.controller;

import com.example.backend.dto.OrderDto;
import com.example.backend.entity.Orders;
import com.example.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/place/order")
    private Orders createOrder(@RequestBody OrderDto orderDto){
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/get/all/orders")
    private ResponseEntity<List<Orders>> getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @GetMapping("/get/orders/id/{id}")
    private ResponseEntity<Orders>getOderById(@PathVariable Long id){
        return ResponseEntity.status(200).body(orderService.getOrderById(id));
    }
}
