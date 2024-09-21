package com.zurimokato.ms_product.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerProductConfig {
    @Bean
    GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder()
                .group("product-api")
                .pathsToMatch("/**")
                .build();
    }
@Bean
OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info().version("1.0").title("Product API")
        .description("Api for Products"));
}
}
