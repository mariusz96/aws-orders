package com.mariusz96.awsorders.order.repository;

import com.mariusz96.awsorders.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o join fetch o.orderItems where o.id = ?1")
    Optional<Order> findOrderById(int id);
}
