package com.mariusz96.awsorders.order;

import java.math.BigDecimal;

public record GetOrderResponseItem(

        int productId,

        int quantity,

        BigDecimal unitPrice) {
}
