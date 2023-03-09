package com.breakingbad.workerhub.core.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConfigurationProperties(prefix = "api")
public class ApiConfigProperties {

    private final Kasi kasi;

    @ConstructorBinding
    public ApiConfigProperties(Kasi kasi) {
        this.kasi = kasi;
    }

    @Getter
    public static class Kasi {
        private final String key;

        @ConstructorBinding
        public Kasi(String key) {
            this.key = key;
        }
    }

}

