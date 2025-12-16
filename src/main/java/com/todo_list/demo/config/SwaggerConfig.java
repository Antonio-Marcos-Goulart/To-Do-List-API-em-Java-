package com.todo_list.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI OpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("LISTA DE TAREFAS API COM BANCO DE DADOS")
                        .version("1.0.0.0")
                        .description("Documentação base da API")
                        .contact(new Contact()
                                .name("Antônio Marcos")
                                .email("antoniomarcos5674335@gmail.com")));
    }
}

// http://localhost:8080/swagger-ui/index.html