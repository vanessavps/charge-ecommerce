package com.charge.ecommerce.controller;

import com.charge.ecommerce.entity.Order;
import com.charge.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/submit")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order newOrder = orderService.submitOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

}
