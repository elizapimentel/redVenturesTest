package com.redventures.elizaTest.controllers;

import com.redventures.elizaTest.controllers.exceptionsHandler.StandardError;
import com.redventures.elizaTest.dto.OrderRequestDTO;
import com.redventures.elizaTest.dto.OrderResponseDTO;
import com.redventures.elizaTest.model.Broth;
import com.redventures.elizaTest.model.Protein;
import com.redventures.elizaTest.services.OrderService;
import com.redventures.elizaTest.services.RamenItemsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class OrderController {

    @Qualifier("orderServiceImpl")
    @Autowired
    private OrderService service;

    @Qualifier("ramenItemsServiceImpl")
    @Autowired
    private RamenItemsService ramenService;

    @Operation(summary = "List all available broths")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of broths", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Broth.class),
                    examples = @ExampleObject(value = "[{\n" +
                            "  \"id\": \"1\",\n" +
                            "  \"imageInactive\": \"https://tech.redventures.com.br/icons/salt/inactive.svg\",\n" +
                            "  \"imageActive\": \"https://tech.redventures.com.br/icons/salt/active.svg\",\n" +
                            "  \"name\": \"Salt\",\n" +
                            "  \"description\": \"Simple like the seawater, nothing more\",\n" +
                            "  \"price\": 10\n" +
                            "}]"))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"error\": \"x-api-key header missing\"\n" +
                            "}")))
    })
    @GetMapping("/broths")
    public ResponseEntity<List<Broth>> getAllBroths(
            @RequestHeader(value = "x-api-key", required = true) String authorizationHeader) {
        try {
            List<Broth> products = ramenService.getAllBroths();
            return ResponseEntity.status(200).body(products);
        } catch (Error e) {
            return ResponseEntity.status(403).build();
        }
    }

    @Operation(summary = "List all available proteins")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A list of proteins", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Protein.class),
                    examples = @ExampleObject(value = "[{\n" +
                            "  \"id\": \"1\",\n" +
                            "  \"imageInactive\": \"https://tech.redventures.com.br/icons/salt/inactive.svg\",\n" +
                            "  \"imageActive\": \"https://tech.redventures.com.br/icons/salt/active.svg\",\n" +
                            "  \"name\": \"Chasu\",\n" +
                            "  \"description\": \"A sliced flavourful pork meat with a selection of season vegetables.\",\n" +
                            "  \"price\": 10\n" +
                            "}]"))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"error\": \"x-api-key header missing\"\n" +
                            "}")))
    })
    @GetMapping("/proteins")
    public ResponseEntity<List<Protein>> getAllProteins(
            @RequestHeader(value = "x-api-key", required = true) String authorizationHeader) {
        List<Protein> products = ramenService.getAllProteins();
        return ResponseEntity.status(200).body(products);
    }


    @Operation(summary = "Place an order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order placed successfully", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OrderResponseDTO.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"id\": \"12345\",\n" +
                            "  \"description\": \"Salt and Chasu Ramen\",\n" +
                            "  \"image\": \"https://tech.redventures.com.br/icons/ramen/ramenChasu.png\"\n" +
                            "}"))),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"error\": \"both brothId and proteinId are required\"\n" +
                            "}"))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content =@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"error\": \"x-api-key header missing\"\n" +
                            "}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content =@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = StandardError.class),
                    examples = @ExampleObject(value = "{\n" +
                            "  \"error\": \"could not place order\"\n" +
                            "}"))),
    })
    @PostMapping(value = "/orders/order-id")
    public ResponseEntity<OrderResponseDTO> createOrder(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Order details",
                    required = true,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = OrderRequestDTO.class),
                            examples = @ExampleObject(value = "{\n" +
                                    "  \"brothId\": \"1\",\n" +
                                    "  \"proteinId\": \"1\"\n" +
                                    "}")))
            @RequestBody OrderRequestDTO orderRequest,
            @RequestHeader(value = "x-api-key", required = true) String authorizationHeader) {
        try {
            return ResponseEntity.status(201).body(service.createOrder(orderRequest));
        } catch (Error e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}

