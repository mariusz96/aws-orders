package io.github.mariusz96.awsorders;

import java.util.List;

public record GetOrderResponse(

        int orderId,

        List<GetOrderResponseItem> orderItems) {
}
