package com.breakingbad.workerhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfigurationPackage(basePackages = "com.breakingbad.workerhub")
@SpringBootApplication(scanBasePackages = "com.breakingbad.workerhub")
public class ModuleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleWebApplication.class, args);
    }
}