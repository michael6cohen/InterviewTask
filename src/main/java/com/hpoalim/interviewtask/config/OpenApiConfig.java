package com.hpoalim.interviewtask.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Async Task Processor API")
                        .version("1.0")
                        .description("This project demonstrates asynchronous task execution and progress tracking using Spring Boot, Redis, and multi-threading."));
    }
}
