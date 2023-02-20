package com.breakingbad.workerhub.core.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.NotNull;

import static com.breakingbad.workerhub.constant.Algorithm.BASE256;
import static com.breakingbad.workerhub.constant.Algorithm.PBEWithMD5AndDES;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {

    private static final String ITERATION = "1000";

    private static final String POOL_SIZE = "2";

    private static final String GENERATOR_CLASS_NAME = "org.jasypt.salt.RandomSaltGenerator";

    @Bean
    @Primary
    public StringEncryptor jasyptStringEncryptor(@NotNull @Value("${jasypt.encryptor.password}") String key) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm(PBEWithMD5AndDES.getValue());
        config.setKeyObtentionIterations(ITERATION);
        config.setPoolSize(POOL_SIZE);
        config.setSaltGeneratorClassName(GENERATOR_CLASS_NAME);
        config.setStringOutputType(BASE256.getValue());
        encryptor.setConfig(config);
        return encryptor;
    }

}
