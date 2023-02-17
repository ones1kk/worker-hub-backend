package com.breakingbad.workerhub.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static com.breakingbad.workerhub.constant.ApiDocument.*;

@Configuration
public class OpenApiConfig {

    @Bean
    @Primary
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(new Info()
                .title(TITLE.getValue())
                .description(DESCRIPTION.getValue())
                .version(VERSION.getValue())
                .contact(getContact()));
    }

    private Contact getContact() {
        return new Contact()
                .name(CONTACT_NAME.getValue())
                .email(CONTACT_EMAIL.getValue());
    }

}
