package com.example.ia.application;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_4_O_MINI;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.inject.Singleton;

@Singleton
public class PromptFlow {

    public String talk() {
        ChatLanguageModel chatModel = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(GPT_4_O_MINI)
                .temperature(0.2)
                .build();

        String answer = chatModel.chat("Escreva uma frase sobre o descobrimento do brasil");

        return answer;
    }
}
