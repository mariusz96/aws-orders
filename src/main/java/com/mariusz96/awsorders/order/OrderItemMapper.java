package com.mariusz96.awsorders.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {

    @Mapping(target = "id", ignore = true)
    OrderItem toOrderItem(CreateOrderRequestItem createOrderRequestItem);
}
