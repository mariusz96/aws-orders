package io.github.mariusz96.awsorders;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {

    @Mapping(target = "id", ignore = true)
    OrderItem toOrderItem(CreateOrderRequestItem requestItem);
}
