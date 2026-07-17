package com.mariusz96.awsorders.order;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    OrderRepository repository = mock(OrderRepository.class);
    OrderService service = new OrderService(repository);

    @Test
    void getsOrderIfExists() {
        var expected = new Order();
        when(repository.findOrderById(1))
                .thenReturn(Optional.of(expected));

        var actual = service.getOrder(1);

        assertEquals(expected, actual.orElseThrow());
    }

    @Test
    void getsEmptyIfOrderDoesNotExist() {
        when(repository.findById(1))
                .thenReturn(Optional.empty());

        var actual = service.getOrder(1);

        assertTrue(actual.isEmpty());
    }
}
