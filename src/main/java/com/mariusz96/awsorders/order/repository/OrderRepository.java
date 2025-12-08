package com.mariusz96.awsorders.order.repository;

import com.mariusz96.awsorders.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
