package com.breakingbad.workerhub.domain.audting.provider;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorProvider implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("test");
    }
}
