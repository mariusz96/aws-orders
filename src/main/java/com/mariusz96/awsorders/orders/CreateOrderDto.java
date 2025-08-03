package com.mariusz96.awsorders.orders;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateOrderDto(
        @Valid
        @NotEmpty
        List<CreateOrderItemDto> orderItems) {
}
