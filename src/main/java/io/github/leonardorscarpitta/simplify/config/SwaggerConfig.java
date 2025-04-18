package io.github.leonardorscarpitta.simplify.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI openApi = new OpenAPI();
        openApi.info(new Info()
                .title("API de gerenciamento de tarefas")
<<<<<<< HEAD
                .version("1.0")
=======
                .version("1.0.0")
>>>>>>> c41a679 (feat(config): add Swagger OpenAPI configuration for API documentation)
                .description("Desenvolvi essa aplicação para me aprofundar nos conceitos de CRUD, validação de dados, injeção de dependencias, testes unitários, documentação com Swagger e respostas de requisições.")
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("MIT").url("https://opensource.org/licenses/MIT"))
                .contact(new Contact().name("Leonardo Scarpitta").url("https://www.linkedin.com/in/leonardorscarpitta/"))
        );
        return openApi;
    }
}
