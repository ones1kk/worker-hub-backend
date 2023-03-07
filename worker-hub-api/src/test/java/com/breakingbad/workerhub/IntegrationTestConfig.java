package com.breakingbad.workerhub;

import com.breakingbad.workerhub.core.config.AppConfig;
import com.breakingbad.workerhub.core.config.AuditConfig;
import com.breakingbad.workerhub.core.config.QuerydslConfig;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;

@Import(value = {AuditConfig.class, AppConfig.class, QuerydslConfig.class})
@Configuration
@EnableEncryptableProperties
@ConfigurationPropertiesScan
public class IntegrationTestConfig {

    @MockBean
    private JpaMetamodelMappingContext jpaMetamodelMappingContext;

}
