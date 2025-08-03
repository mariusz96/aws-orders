package com.mariusz96.awsorders.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        int productId,
        int quantity,
        BigDecimal unitPrice) {
}
