package com.example.ia.domain.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public record PromptDTO(String input) {

    public String getUserIdentifier() {
        return "1";
    }
}
