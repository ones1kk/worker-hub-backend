package com.breakingbad.workerhub;

import com.breakingbad.workerhub.core.config.AuditConfig;
import com.breakingbad.workerhub.core.crypto.Crypto;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@Import(AuditConfig.class)
public class TestIntegrationConfig {

    @MockBean
    private Crypto crypto;

    @MockBean
    private PasswordEncoder passwordEncoder;
}
