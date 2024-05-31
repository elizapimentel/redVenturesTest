package com.redventures.elizaTest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO implements Serializable {

    @NotNull
    private String brothId;
    @NotNull
    private String proteinId;

}
