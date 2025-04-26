package com.example.ia.presentation;

import com.example.ia.application.PromptFlow;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;

@Controller("/input")
@RequiredArgsConstructor
public class PromptController {

    private final @Nonnull PromptFlow flow;

    @Get(produces = MediaType.TEXT_PLAIN)
    public String input() {
        return flow.talk();
    }
}
