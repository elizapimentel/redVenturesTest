package com.redventures.elizaTest.services;

import com.redventures.elizaTest.dto.OrderRequestDTO;
import com.redventures.elizaTest.dto.OrderResponseDTO;
import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import com.redventures.elizaTest.repositories.BrothRepository;
import com.redventures.elizaTest.repositories.ProteinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BrothRepository brothRepo;

    @Autowired
    private ProteinRepository proteinRepo;

    private static final int MAX_ID = 99999;
    private static long generateRandomId() {
        return ThreadLocalRandom.current().nextLong(1, MAX_ID + 1);
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequest) {

        Broth broth = brothRepo.findById(orderRequest.getBrothId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid broth"));
        Protein protein = proteinRepo.findById(orderRequest.getProteinId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid protein"));

        String description = broth.getName() + " and " + protein.getName() + " Ramen";
        String image = "https://tech.redventures.com.br/icons/ramen/" + protein.getImageActive();

        long newOrderId = generateRandomId();
        String orderId = String.format("%05d", newOrderId);

        return new OrderResponseDTO(orderId, description, image);
    }
}
