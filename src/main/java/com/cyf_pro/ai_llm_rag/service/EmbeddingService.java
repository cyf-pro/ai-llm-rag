package com.cyf_pro.ai_llm_rag.service;

import com.cyf_pro.ai_llm_rag.feignclient.EmbeddingServiceClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbeddingService {
    private final EmbeddingServiceClient embeddingServiceClient;

    public EmbeddingService(EmbeddingServiceClient embeddingServiceClient) {
        this.embeddingServiceClient = embeddingServiceClient;
    }

    public List<Float> getVector(String text) {
        return embeddingServiceClient.getStringVector(text).getBody().getVector();
    }
}
