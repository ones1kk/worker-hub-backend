package com.breakingbad.workerhub.core.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "api")
public class ApiConfigProperties {

    private Kasi kasi;

    @Getter
    @AllArgsConstructor
    @ConstructorBinding
    public static class Kasi {
        private String key;
    }

}

