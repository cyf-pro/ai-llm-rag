package com.cyf_pro.ai_llm_rag.service;

import com.cyf_pro.ai_llm_rag.entity.Content;
import com.cyf_pro.ai_llm_rag.repository.ContentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentQueryService {
    private final ContentRepository contentRepository;

    public ContentQueryService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }
}
