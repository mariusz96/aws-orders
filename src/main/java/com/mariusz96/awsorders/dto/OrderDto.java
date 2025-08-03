package com.mariusz96.awsorders.dto;

import java.util.List;

public record OrderDto(
        int orderId,
        List<OrderItemDto> orderItems) {
}
