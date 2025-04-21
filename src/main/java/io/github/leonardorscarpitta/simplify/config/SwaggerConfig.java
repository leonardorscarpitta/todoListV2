package io.github.leonardorscarpitta.simplify.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        Components component = new Components();
        Map<String, String> response = Map.of(
                "badRequest", "Requisição inválida!",
                "unauthorized", "Não autorizado!",
                "forbidden", "Não autorizado!",
                "notFound", "Recurso não encontrado!",
                "conflict", "Conflito no estado do recurso!",
                "internalError", "Erro interno do servidor!"
        );

        for (Map.Entry<String, String> entry: response.entrySet()) {
            component.addResponses(entry.getKey(), new ApiResponse().description(entry.getValue()));
        }

        openApi.info(new Info()
                .title("API de gerenciamento de tarefas")
                .version("1.0.0")
                .description("Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários, documentação com Swagger e respostas de requisições.")
                .contact(new Contact().name("Leonardo Rocha Scarpitta").url("https://www.linkedin.com/in/leonardorscarpitta/"))
        );

        return openApi;
    }
}
