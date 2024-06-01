package com.redventures.elizaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO implements Serializable {

    private String id;
    private String description;
    private String image;
}
