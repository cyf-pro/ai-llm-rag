package com.cyf_pro.ai_llm_rag.repository;

import com.cyf_pro.ai_llm_rag.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
