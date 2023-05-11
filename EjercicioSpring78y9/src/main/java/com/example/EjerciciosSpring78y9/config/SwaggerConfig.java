package com.example.EjerciciosSpring78y9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Spring Boot Laptop API REST",
                "Laptops Api rest docs",
                "1.0",
                "https://www.fullaventura.com",
                new Contact("Juan", "https://www.fullaventura.com", "JuanitoPistolas@example.com"),
                "MIT",
                "https://www.fullaventura.com",
                Collections.emptyList());
    }

}
