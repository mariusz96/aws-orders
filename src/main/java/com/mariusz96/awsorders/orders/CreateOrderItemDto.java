package com.mariusz96.awsorders.orders;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateOrderItemDto(
        @Positive
        int productId,
        @Positive
        int quantity,
        @Positive
        BigDecimal unitPrice) {
}
