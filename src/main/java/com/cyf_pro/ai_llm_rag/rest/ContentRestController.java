package com.cyf_pro.ai_llm_rag.rest;

import com.cyf_pro.ai_llm_rag.entity.Content;
import com.cyf_pro.ai_llm_rag.service.ContentCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/contents")
public class ContentRestController {
    private final ContentCommandService contentCommandService;

    public ContentRestController(ContentCommandService contentCommandService) {
        this.contentCommandService = contentCommandService;
    }

    @PostMapping
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        return ResponseEntity.ok(contentCommandService.createContent(content));
    }
}
