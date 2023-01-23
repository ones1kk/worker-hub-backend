package com.breakingbad.workerhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ModuleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleWebApplication.class, args);
    }
}