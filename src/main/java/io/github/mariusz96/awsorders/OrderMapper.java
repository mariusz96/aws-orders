package io.github.mariusz96.awsorders;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    GetOrderResponse toGetOrderResponse(Order order);

    @Mapping(target = "id", ignore = true)
    Order toOrder(CreateOrderRequest request);
}
