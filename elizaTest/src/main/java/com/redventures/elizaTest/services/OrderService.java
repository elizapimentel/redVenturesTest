package com.redventures.elizaTest.services;

import com.redventures.elizaTest.dto.OrderRequestDTO;
import com.redventures.elizaTest.dto.OrderResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequest);
}
