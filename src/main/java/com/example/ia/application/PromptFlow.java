package com.example.ia.application;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O;

import com.example.ia.domain.dto.AnswerDTO;
import com.example.ia.domain.dto.PromptDTO;
import com.example.ia.infrastructure.message.Assistant;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import jakarta.annotation.Nonnull;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class PromptFlow {

    private final @Nonnull ChatMemoryStore store;

    @Nonnull
    public AnswerDTO talk(PromptDTO prompt) {
        ChatMemoryProvider chatMemoryProvider = memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(store)
                .build();
        ChatLanguageModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(GPT_4_O)
                .temperature(0.9)
                .build();
        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(chatModel)
                .chatMemoryProvider(chatMemoryProvider)
                .build();

        String answer = assistant.chat("1", prompt.getInput());

        return AnswerDTO.builder()
                .output(answer)
                .build();
    }
}
