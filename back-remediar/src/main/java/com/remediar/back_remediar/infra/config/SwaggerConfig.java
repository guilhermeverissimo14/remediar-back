package com.remediar.back_remediar.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${server.servlet.context-path:}")
    private String contextPath;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API - Remediar")
                        .version("1.0")
                        .description("Documentação da API da ONG Remediar"))
                .servers(List.of(
                        new Server()
                                .url("https://remediar-api.mgioqc.easypanel.host" + contextPath)
                                .description("Servidor de Produção"),
                        new Server()
                                .url("http://localhost:8081" + contextPath)
                                .description("Servidor Local")
                ));
    }
}