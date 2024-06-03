package com.redventures.elizaTest.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ramenGo - Redventures Test")
                        .description("This API allows users to list available broths, available proteins and place an order.")
                        .version("1.0")
                        .termsOfService("Terms of service URL")
                        .contact(new Contact()
                                .name("Eliza Pimentel")
                                .email("elizapimentel@hotmail.com"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("License of API")
                                .url("API license URL")))
                .addSecurityItem(new SecurityRequirement().addList("apiKey"))
                .components(new Components()
                        .addSecuritySchemes("apiKey", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .name("x-api-key")
                                .description("ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf")
                                .in(SecurityScheme.In.HEADER)));
    }

}
