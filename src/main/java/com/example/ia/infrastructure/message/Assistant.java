package com.example.ia.infrastructure.message;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface Assistant {

    String chat(@MemoryId String memoryId, @UserMessage String message);
}
