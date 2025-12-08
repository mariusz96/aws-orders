package com.mariusz96.awsorders.order.service;

import com.mariusz96.awsorders.order.entity.Order;
import com.mariusz96.awsorders.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Optional<Order> getOrder(int id) {
        return repository.findById(id);
    }

    public void createOrder(Order order) {
        repository.save(order);
    }
}
