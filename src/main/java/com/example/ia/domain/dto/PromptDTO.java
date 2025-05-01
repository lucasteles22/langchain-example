package com.example.ia.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;

@Serdeable
@Builder
@Getter
public class PromptDTO {

    @NotBlank
    @NotEmpty
    @Nonnull
    private final String input;
}
