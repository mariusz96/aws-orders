package com.mariusz96.awsorders.controller;

import com.mariusz96.awsorders.dto.CreateOrderDto;
import com.mariusz96.awsorders.dto.OrderDto;
import com.mariusz96.awsorders.mapper.OrderMapper;
import com.mariusz96.awsorders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    private final OrderMapper mapper;

    public OrderController(OrderService service, OrderMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable int id) {
        var order = service.getOrder(id);
        return order
                .map(value -> ResponseEntity.ok(mapper.orderToOrderDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> createOrder(
            @Valid @RequestBody CreateOrderDto createOrder) {
        var order = mapper.createOrderDtoToOrder(createOrder);
        service.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order.getId());
    }
}
