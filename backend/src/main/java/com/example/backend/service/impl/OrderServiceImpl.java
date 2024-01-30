package com.example.backend.service.impl;

import com.example.backend.dto.OrderDto;
import com.example.backend.entity.Orders;
import com.example.backend.entity.Product;
import com.example.backend.reposiory.OrdersRepository;
import com.example.backend.reposiory.ProductRepository;
import com.example.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;
    @Override
    public Orders createOrder(OrderDto orderDto) {
        List<Long> productIds = orderDto.getProducts();

        Set<Product> products = new HashSet<>();
        Double total = 0.0;

        for(Long productId : productIds) { //Looping through product Ids.
            Product product = productRepository.findById(productId).orElse(null);

            if(product != null && product.getQty() != 0) {
                //add this to the Product Set
                products.add(product);
                total = total + product.getPrice();
                product.setQty(product.getQty() - 1);
                productRepository.save(product);
            }
        }

        LocalDateTime dateTime = LocalDateTime.now();

        Orders order = new Orders();
        order.setTotal(total);
        order.setDate(dateTime);
        order.setProducts(products);

        return ordersRepository.save(order);
    }

    @Override
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }
}
