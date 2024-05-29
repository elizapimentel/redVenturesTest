package com.redventures.elizaTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO implements Serializable {

    private String brothId;
    private String proteinId;

}
