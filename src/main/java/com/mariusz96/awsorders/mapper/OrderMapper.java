package com.mariusz96.awsorders.mapper;

import com.mariusz96.awsorders.dto.CreateOrderDto;
import com.mariusz96.awsorders.dto.OrderDto;
import com.mariusz96.awsorders.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = OrderItemMapper.class)
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    OrderDto orderToOrderDto(Order order);

    @Mapping(target = "id", ignore = true)
    Order createOrderDtoToOrder(CreateOrderDto createOrderDto);
}
