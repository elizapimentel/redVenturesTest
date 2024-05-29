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

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BrothRepository brothRepo;

    @Autowired
    private ProteinRepository proteinRepo;

    public OrderResponseDTO createOrder(OrderRequestDTO orderRequest) {
        UUID brothId = UUID.fromString(orderRequest.getBrothId());
        UUID proteinId = UUID.fromString(orderRequest.getProteinId());

        Broth broth = brothRepo.findById(brothId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid broth ID"));
        Protein protein = proteinRepo.findById(proteinId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid protein ID"));

        String description = broth.getName() + " and " + protein.getName() + " Ramen";
        String image = "https://tech.redventures.com.br/icons/ramen/" + protein.getImageActive();

        return new OrderResponseDTO(UUID.randomUUID(), description, image);
    }
}
