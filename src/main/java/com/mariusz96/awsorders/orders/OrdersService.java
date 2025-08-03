package com.mariusz96.awsorders.orders;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository repository;

    public OrdersService(OrdersRepository repository) {
        this.repository = repository;
    }

    public Optional<Order> getOrder(int id) {
        return repository.findById(id);
    }

    public void createOrder(Order order) {
        repository.save(order);
    }
}
