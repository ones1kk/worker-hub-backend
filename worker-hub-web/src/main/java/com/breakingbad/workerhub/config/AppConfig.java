package com.breakingbad.workerhub.config;

import com.breakingbad.workerhub.constant.Profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.NotBlank;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public Profiles activeSpringProfile(@NotBlank @Value("${spring.config.activate.on-profile}") String profile) {
        return Profiles.from(profile);
    }
}
