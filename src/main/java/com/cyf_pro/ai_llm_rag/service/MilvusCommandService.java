package com.cyf_pro.ai_llm_rag.service;

import io.milvus.client.MilvusServiceClient;
import io.milvus.param.collection.FlushParam;
import io.milvus.param.dml.InsertParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilvusCommandService {
    private final MilvusServiceClient milvusServiceClient;

    public MilvusCommandService(MilvusServiceClient milvusServiceClient) {
        this.milvusServiceClient = milvusServiceClient;
    }

    public void upsert(Long contentId, List<Float> vector) {
        List<InsertParam.Field> fields = List.of(
                new InsertParam.Field("content_id", List.of(contentId)),
                new InsertParam.Field("vector_field", List.of(vector))
        );

        InsertParam insertParam = InsertParam.newBuilder()
                .withCollectionName("contents")
                .withFields(fields)
                .build();

        milvusServiceClient.insert(insertParam);
        milvusServiceClient.flush(FlushParam.newBuilder()
                        .withCollectionNames(List.of("contents"))
                .build());
    }
}
