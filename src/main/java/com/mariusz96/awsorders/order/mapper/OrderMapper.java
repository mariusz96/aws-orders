package com.mariusz96.awsorders.order.mapper;

import com.mariusz96.awsorders.order.dto.CreateOrderDto;
import com.mariusz96.awsorders.order.dto.OrderDto;
import com.mariusz96.awsorders.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = OrderItemMapper.class)
public interface OrderMapper {
    @Mapping(source = "id", target = "orderId")
    OrderDto orderToOrderDto(Order order);

    @Mapping(target = "id", ignore = true)
    Order createOrderDtoToOrder(CreateOrderDto createOrderDto);
}
