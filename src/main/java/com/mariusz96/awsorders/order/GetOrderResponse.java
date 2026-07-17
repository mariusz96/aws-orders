package com.mariusz96.awsorders.order;

import java.util.List;

public record GetOrderResponse(

        int orderId,

        List<GetOrderResponseItem> orderItems) {
}
