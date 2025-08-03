package com.mariusz96.awsorders.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
