package io.github.mariusz96.awsorders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderIntegrationTest extends IntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void createsValidOrder() {
        var validOrder = new CreateOrderRequest(
                List.of(new CreateOrderRequestItem(2, 4, BigDecimal.TEN))
        );

        var response = restTemplate.postForEntity("/orders", validOrder, Integer.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
    }

    @ParameterizedTest
    @MethodSource("invalidOrders")
    void validatesInvalidOrder(CreateOrderRequest invalidOrder) {
        var response = restTemplate.postForEntity("/orders", invalidOrder, Void.class);

        assertTrue(response.getStatusCode().is4xxClientError());
    }

    static List<CreateOrderRequest> invalidOrders() {
        //noinspection DataFlowIssue
        return List.of(
                new CreateOrderRequest(
                        List.of(new CreateOrderRequestItem(-2, 4, BigDecimal.TEN))
                ),
                new CreateOrderRequest(
                        List.of(new CreateOrderRequestItem(2, -4, BigDecimal.TEN))
                ),
                new CreateOrderRequest(
                        List.of(new CreateOrderRequestItem(2, 4, BigDecimal.TEN.negate()))
                ));
    }
}
