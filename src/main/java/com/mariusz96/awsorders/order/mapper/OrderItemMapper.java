package com.mariusz96.awsorders.order.mapper;

import com.mariusz96.awsorders.order.dto.CreateOrderItemDto;
import com.mariusz96.awsorders.order.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    @Mapping(target = "id", ignore = true)
    OrderItem createOrderItemDtoToOrderItem(CreateOrderItemDto createOrderItemDto);
}
