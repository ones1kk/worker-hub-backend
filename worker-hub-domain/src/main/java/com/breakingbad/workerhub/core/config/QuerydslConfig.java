package com.breakingbad.workerhub.core.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Configuration
public class QuerydslConfig {

    private final EntityManager entityManager;

    @Bean
    @Primary
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

}
