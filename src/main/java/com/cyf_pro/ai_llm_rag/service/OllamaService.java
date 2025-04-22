package com.cyf_pro.ai_llm_rag.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
    private final ChatClient chatClient;

    public OllamaService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}
