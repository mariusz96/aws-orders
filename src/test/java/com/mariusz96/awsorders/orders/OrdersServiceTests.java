package com.mariusz96.awsorders.orders;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrdersServiceTests {
    @Test
    void getsOrderIfExists() {
        var expected = new Order();
        var repository = mock(OrdersRepository.class);
        when(repository.findById(1))
                .thenReturn(Optional.of(expected));
        var service = new OrdersService(repository);

        var actual = service.getOrder(1);

        assertEquals(expected, actual.orElseThrow());
    }

    @Test
    void getsEmptyIfOrderDoesNotExist() {
        var repository = mock(OrdersRepository.class);
        when(repository.findById(1))
                .thenReturn(Optional.empty());
        var service = new OrdersService(repository);

        var actual = service.getOrder(1);

        assertTrue(actual.isEmpty());
    }
}
