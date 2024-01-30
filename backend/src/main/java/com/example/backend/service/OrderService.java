package com.example.backend.service;

import com.example.backend.dto.OrderDto;
import com.example.backend.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Orders createOrder(OrderDto orderDto);

    Orders getOrderById(Long id);

    List<Orders> getAllOrders();
}
