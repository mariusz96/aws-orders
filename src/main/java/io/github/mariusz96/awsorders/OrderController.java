package io.github.mariusz96.awsorders;

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
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable int id) {
        var order = service.getOrder(id);

        return order
                .map(value -> ResponseEntity.ok(mapper.toGetOrderResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        var order = mapper.toOrder(request);

        service.createOrder(order);

        return ResponseEntity.status(HttpStatus.CREATED).body(order.getId());
    }
}
