package com.breakingbad.workerhub;

import com.breakingbad.workerhub.constant.Profiles;
import com.breakingbad.workerhub.core.config.AppConfig;
import com.breakingbad.workerhub.core.config.AuditConfig;
import com.breakingbad.workerhub.core.config.RetrofitConfig;
import com.breakingbad.workerhub.core.crypto.Crypto;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@Import(value = {AuditConfig.class, RetrofitConfig.class})
public class IntegrationTestConfig {

    @MockBean
    private AppConfig appConfig;

    @MockBean
    private JpaMetamodelMappingContext jpaMetamodelMappingContext;

}
