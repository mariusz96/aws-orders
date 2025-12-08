package com.mariusz96.awsorders.order.mapper;

import com.mariusz96.awsorders.order.dto.CreateOrderItemDto;
import com.mariusz96.awsorders.order.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderItemMapper {
    @Mapping(target = "id", ignore = true)
    OrderItem createOrderItemDtoToOrderItem(CreateOrderItemDto createOrderItemDto);
}
