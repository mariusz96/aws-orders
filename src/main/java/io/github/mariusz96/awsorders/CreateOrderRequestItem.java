package io.github.mariusz96.awsorders;

import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateOrderRequestItem(

        @Positive
        int productId,

        @Positive
        int quantity,

        @Positive
        BigDecimal unitPrice) {
}
