package com.mariusz96.awsorders.order.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        int productId,
        int quantity,
        BigDecimal unitPrice) {
}
