package com.mariusz96.awsorders.order.dto;

import java.util.List;

public record OrderDto(
        int orderId,
        List<OrderItemDto> orderItems) {
}
