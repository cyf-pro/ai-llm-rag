package com.cyf_pro.ai_llm_rag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AiLlmRagApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiLlmRagApplication.class, args);
	}

}
