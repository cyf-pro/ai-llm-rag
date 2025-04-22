package com.cyf_pro.ai_llm_rag.rest;

import com.cyf_pro.ai_llm_rag.service.MilvusQueryService;
import com.cyf_pro.ai_llm_rag.service.OllamaService;
import com.cyf_pro.ai_llm_rag.service.PromptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/prompt")
public class PromptRestController {
    private final PromptService promptService;

    public PromptRestController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Long> chat(@RequestBody String prompt) {
        return ResponseEntity.ok(promptService.processPrompt(prompt));
    }
}
