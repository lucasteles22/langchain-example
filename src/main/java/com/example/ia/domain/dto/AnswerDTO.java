package com.example.ia.domain.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;

@Serdeable
@Builder
@Getter
public class AnswerDTO {

    public AnswerDTO(String output) {
        this.output = output;
    }

    private final @Nonnull String output;
}
