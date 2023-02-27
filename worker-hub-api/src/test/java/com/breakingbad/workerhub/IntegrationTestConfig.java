package com.breakingbad.workerhub;

import com.breakingbad.workerhub.core.config.AppConfig;
import com.breakingbad.workerhub.core.config.AuditConfig;
import com.breakingbad.workerhub.core.config.JasyptConfig;
import com.breakingbad.workerhub.core.properties.ApiConfigProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;

import javax.validation.constraints.NotNull;

@Import(value = {AuditConfig.class, AppConfig.class, JasyptConfig.class})
@Configuration
@EnableEncryptableProperties
public class IntegrationTestConfig {

    @MockBean
    private JpaMetamodelMappingContext jpaMetamodelMappingContext;

    @Bean
    @DependsOn("jasyptStringEncryptor")
    public ApiConfigProperties apiConfigProperties(@NotNull @Value("${api.kasi.key}") String key) {
        return new ApiConfigProperties(kasi(key));
    }

    @Bean
    public ApiConfigProperties.Kasi kasi(@NotNull @Value("${api.kasi.key}") String key) {
        return new ApiConfigProperties.Kasi(key);
    }

}
