package com.cyf_pro.ai_llm_rag.service;

import com.cyf_pro.ai_llm_rag.entity.Content;
import com.cyf_pro.ai_llm_rag.repository.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class ContentCommandService {
    private final ContentRepository contentRepository;
    private final MilvusCommandService milvusCommandService;
    private final EmbeddingService embeddingService;

    public ContentCommandService(ContentRepository contentRepository, MilvusCommandService milvusCommandService, EmbeddingService embeddingService) {
        this.contentRepository = contentRepository;
        this.milvusCommandService = milvusCommandService;
        this.embeddingService = embeddingService;
    }

    public Content createContent(Content content) {
        Content createdContent = contentRepository.save(content);
        milvusCommandService.upsert(createdContent.getId(), embeddingService.getVector(createdContent.getTitle() + " " + createdContent.getDescription()));
        return createdContent;
    }
}
