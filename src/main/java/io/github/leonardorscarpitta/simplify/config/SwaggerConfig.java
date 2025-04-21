package io.github.leonardorscarpitta.simplify.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();

        openApi.components(new Components()
                .addResponses("badRequest", new ApiResponse().description("Requisição inválida!"))
                .addResponses("unauthorized", new ApiResponse().description("Não autorizado!"))
                .addResponses("forbidden", new ApiResponse().description("Acesso proibido!"))
                .addResponses("notFound", new ApiResponse().description("Recurso não encontrado!"))
                .addResponses("conflict", new ApiResponse().description("Conflito no estado do recurso!"))
                .addResponses("internalError", new ApiResponse().description("Erro interno do servidor!"))
        );

        openApi.info(new Info()
                .title("API de gerenciamento de tarefas")
                .version("1.0.0")
                .description("Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários, documentação com Swagger e respostas de requisições.")
                .contact(new Contact().name("Leonardo Rocha Scarpitta").url("https://www.linkedin.com/in/leonardorscarpitta/"))
        );

        return openApi;
    }
}
