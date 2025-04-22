package com.cyf_pro.ai_llm_rag.feignclient;

import com.cyf_pro.ai_llm_rag.dto.EmbeddingServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "embedding-service", url = "${embedding-service.url}")
public interface EmbeddingServiceClient {
    @GetMapping
    public ResponseEntity<EmbeddingServiceResponse> getStringVector(@RequestParam(name = "text") String text);
}
