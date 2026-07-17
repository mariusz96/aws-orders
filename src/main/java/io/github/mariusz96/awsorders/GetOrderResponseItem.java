package io.github.mariusz96.awsorders;

import java.math.BigDecimal;

public record GetOrderResponseItem(

        int productId,

        int quantity,

        BigDecimal unitPrice) {
}
