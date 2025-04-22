package com.cyf_pro.ai_llm_rag.config;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.ConnectParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MilvusConfig {
    @Bean
    public MilvusServiceClient milvusClient() {
        ConnectParam connectParam = ConnectParam.newBuilder()
                .withHost("localhost")
                .withPort(19530)
                .withDatabaseName("ai_llm_rag_db")
                .build();
        return new MilvusServiceClient(connectParam);
    }
}
