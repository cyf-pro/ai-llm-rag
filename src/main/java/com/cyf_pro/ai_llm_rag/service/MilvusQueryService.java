package com.cyf_pro.ai_llm_rag.service;

import io.milvus.client.MilvusServiceClient;
import io.milvus.grpc.SearchResults;
import io.milvus.param.MetricType;
import io.milvus.param.R;
import io.milvus.param.collection.LoadCollectionParam;
import io.milvus.param.dml.SearchParam;
import io.milvus.response.SearchResultsWrapper;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.util.List;

@Service
public class MilvusQueryService {
    private final MilvusServiceClient milvusServiceClient;

    public MilvusQueryService(MilvusServiceClient milvusServiceClient) {
        this.milvusServiceClient = milvusServiceClient;
    }

    public List<Long> searchSimilarContents(List<Float> vector, int topK) {
        milvusServiceClient.loadCollection(
                LoadCollectionParam.newBuilder()
                        .withCollectionName("contents")
                        .build()
        );
        SearchParam searchParam = SearchParam.newBuilder()
                .withCollectionName("contents")
                .withVectorFieldName("vector_field")
                .withMetricType(MetricType.L2)
                .withOutFields(List.of("content_id"))
                .withTopK(topK)
                .withFloatVectors(List.of(vector))
                .build();
        R<SearchResults> resultR = milvusServiceClient.search(searchParam);
        List<SearchResultsWrapper.IDScore> idScores = new SearchResultsWrapper(resultR.getData().getResults()).getIDScore(0);
        return  idScores.stream()
                .map(i -> (Long) i.getFieldValues().get("content_id"))
                .toList();

    }
}
