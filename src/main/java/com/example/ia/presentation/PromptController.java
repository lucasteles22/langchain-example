package com.example.ia.presentation;

import javax.validation.Valid;

import com.example.ia.application.PromptFlow;
import com.example.ia.domain.dto.AnswerDTO;
import com.example.ia.domain.dto.PromptDTO;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;

@Controller("/prompt")
@RequiredArgsConstructor
public class PromptController {

    private final @Nonnull PromptFlow flow;

    @Post
    public HttpResponse<AnswerDTO> input(@Body PromptDTO promptDTO) {
        AnswerDTO answer = flow.talk(promptDTO);

        return HttpResponse.status(HttpStatus.OK)
                .body(answer);
    }
}
