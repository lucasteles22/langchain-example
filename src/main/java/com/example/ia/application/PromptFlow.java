package com.example.ia.application;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O;

import com.example.ia.domain.dto.AnswerDTO;
import com.example.ia.domain.dto.PromptDTO;

import jakarta.annotation.Nonnull;
import jakarta.inject.Singleton;

@Singleton
public class PromptFlow {

    @Nonnull
    public AnswerDTO talk(PromptDTO prompt) {
        ChatLanguageModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(GPT_4_O)
                .temperature(0.9)
                .build();

        String answer = chatModel.chat(prompt.input());

        return AnswerDTO.builder()
                .output(answer)
                .build();
    }
}
