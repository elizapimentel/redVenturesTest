package com.redventures.elizaTest.controllers;

import com.redventures.elizaTest.dto.OrderRequestDTO;
import com.redventures.elizaTest.dto.OrderResponseDTO;
import com.redventures.elizaTest.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Qualifier("orderServiceImpl")
    @Autowired
    private OrderService service;

    @PostMapping("/generate-id")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequest) {
        try {
            return ResponseEntity.status(201).body(service.createOrder(orderRequest));
        } catch (Error e) {
            return ResponseEntity.status(402).build();
        }
    }
}
