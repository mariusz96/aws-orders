package com.mariusz96.awsorders.order.controller;

import com.mariusz96.awsorders.order.dto.CreateOrderDto;
import com.mariusz96.awsorders.order.dto.OrderDto;
import com.mariusz96.awsorders.order.dto.OrderItemDto;
import com.mariusz96.awsorders.order.entity.Order;
import com.mariusz96.awsorders.order.entity.OrderItem;
import com.mariusz96.awsorders.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable int id) {
        var order = service.getOrder(id);

        return order
                .map(order1 -> ResponseEntity.ok(mapOrder(order1)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> createOrder(
            @Valid @RequestBody CreateOrderDto createOrder) {
        var order = new Order();

        var orderItems = order.getOrderItems();
        for (var createOrderItem : createOrder.orderItems()) {
            var orderItem = new OrderItem();
            orderItem.setProductId(createOrderItem.productId());
            orderItem.setQuantity(createOrderItem.quantity());
            orderItem.setUnitPrice(createOrderItem.unitPrice());
            orderItems.add(orderItem);
        }

        service.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(order.getId());
    }

    private static OrderDto mapOrder(Order order) {
        return new OrderDto(
                order.getId(),
                order.getOrderItems()
                        .stream()
                        .map(orderItem -> new OrderItemDto(
                                orderItem.getProductId(),
                                orderItem.getQuantity(),
                                orderItem.getUnitPrice()))
                        .toList());
    }
}
