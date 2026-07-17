package com.mariusz96.awsorders.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateOrderRequest(

        @Valid
        @NotEmpty
        List<CreateOrderRequestItem> orderItems) {
}
