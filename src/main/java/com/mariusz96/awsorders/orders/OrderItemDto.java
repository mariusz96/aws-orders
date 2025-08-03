package com.mariusz96.awsorders.orders;

import java.math.BigDecimal;

public record OrderItemDto(
        int productId,
        int quantity,
        BigDecimal unitPrice) {
}
