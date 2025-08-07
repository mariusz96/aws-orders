package com.mariusz96.awsorders.orders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrdersControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createsValidOrder() throws Exception {
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"orderItems": [{"productId": 2,"quantity": 4,"unitPrice": 16.60}]}
                                """))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            """
            {"orderItems": [{"productId": 2,"quantity": -4,"unitPrice": 16.60}]}
            """,
            """
            {"orderItems": [{"productId": 2,"quantity": 4,"unitPrice": -16.60}]}
            """
    })
    void validatesInvalidOrder(String order) throws Exception {
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(order))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
