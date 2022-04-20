package com.charge.ecommerce.service;

import com.charge.ecommerce.entity.Order;
import com.charge.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class OrderService extends CrudService<Order> {
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
    }


    public Order submitOrder(Order order) {
        BigDecimal totalPrice = order.getOrderItems()
                                     .stream()
                                     .map(item -> item.getPaidPrice()
                                                      .multiply(BigDecimal.valueOf(item.getQuantity())))
                                     .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setTotalPrice(totalPrice);
        order.setCreatedAt(LocalDateTime.now());
        return this.save(order);
    }

}
