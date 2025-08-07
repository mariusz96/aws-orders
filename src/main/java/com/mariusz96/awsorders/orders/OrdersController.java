package com.mariusz96.awsorders.orders;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private final OrdersService service;

    public OrdersController(OrdersService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable int id) {
        return service.getOrder(id)
                .map(OrdersController::mapOrder)
                .map(ResponseEntity::ok)
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
