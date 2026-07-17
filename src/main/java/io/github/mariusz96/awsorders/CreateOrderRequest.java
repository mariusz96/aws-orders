package io.github.mariusz96.awsorders;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateOrderRequest(

        @Valid
        @NotEmpty
        List<CreateOrderRequestItem> orderItems) {
}
