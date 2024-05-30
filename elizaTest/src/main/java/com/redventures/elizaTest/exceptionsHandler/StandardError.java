package com.redventures.elizaTest.exceptionsHandler;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class StandardError {
    private Integer code;
    private String error;
    private String message;
}
