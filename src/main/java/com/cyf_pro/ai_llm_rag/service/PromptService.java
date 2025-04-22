package com.cyf_pro.ai_llm_rag.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptService {
    private final OllamaService ollamaService;
    private final EmbeddingService embeddingService;
    private final MilvusQueryService milvusQueryService;
    private final ContentQueryService contentQueryService;

    public PromptService(OllamaService ollamaService, EmbeddingService embeddingService, MilvusQueryService milvusQueryService, ContentQueryService contentQueryService) {
        this.ollamaService = ollamaService;
        this.embeddingService = embeddingService;
        this.milvusQueryService = milvusQueryService;
        this.contentQueryService = contentQueryService;
    }

    public Long processPrompt(String prompt) {
        List<Float> promptVector = embeddingService.getVector(prompt);
        List<Long> contentIds = milvusQueryService.searchSimilarContents(promptVector, 3);
        return contentIds.get(0);
    }
}