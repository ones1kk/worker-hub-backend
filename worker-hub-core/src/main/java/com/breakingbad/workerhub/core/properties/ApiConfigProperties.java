package com.breakingbad.workerhub.core.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "api")
public class ApiConfigProperties {

    private Kasi kasi;

    @Getter
    @AllArgsConstructor
    public static class Kasi {
        private String key;
    }

}

