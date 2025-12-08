package com.mariusz96.awsorders.order.service;

import com.mariusz96.awsorders.order.entity.Order;
import com.mariusz96.awsorders.order.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTests {
    @Test
    void getsOrderIfExists() {
        var expected = new Order();
        var repository = mock(OrderRepository.class);
        when(repository.findById(1))
                .thenReturn(Optional.of(expected));
        var service = new OrderService(repository);

        var actual = service.getOrder(1);

        assertEquals(expected, actual.orElseThrow());
    }

    @Test
    void getsEmptyIfOrderDoesNotExist() {
        var repository = mock(OrderRepository.class);
        when(repository.findById(1))
                .thenReturn(Optional.empty());
        var service = new OrderService(repository);

        var actual = service.getOrder(1);

        assertTrue(actual.isEmpty());
    }
}
