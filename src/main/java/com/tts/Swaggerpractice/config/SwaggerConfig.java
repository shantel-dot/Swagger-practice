package com.tts.Swaggerpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tts.swaggerpractice"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(buildApiInfoV1());
    }

    private ApiInfo buildApiInfoV1() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("1.0.0")
                .contact(new Contact("Shantel Taylor", "website.com", "developer@website.com"))
                .license("Apache License Version 2.0")
                .license("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Bean
    public Docket apiV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tts.swaggerpractice"))
                .paths(PathSelectors.ant("/v2/**"))
                .build()
                .apiInfo(buildApiInfoV2());
    }

    private ApiInfo buildApiInfoV2() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("2.0.0")
                .contact(new Contact("Shantel Taylor", "website.com", "developer@website.com"))
                .license("Apache License Version 2.0")
                .license("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Bean
    public UiConfiguration buildUIConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.FULL)
                .build();
    }

}