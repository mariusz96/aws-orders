package com.mariusz96.awsorders.orders;

import java.util.List;

public record OrderDto(int orderId, List<OrderItemDto> orderItems) {
}
