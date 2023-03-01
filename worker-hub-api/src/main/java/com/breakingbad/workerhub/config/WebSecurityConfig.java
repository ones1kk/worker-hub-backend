package com.breakingbad.workerhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.stream.Stream;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        configure(http);
        authorizeRequest(http);
        return http.build();
    }

    private void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement()
                .sessionCreationPolicy(STATELESS);
    }

    private void authorizeRequest(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 정적 리소스 및 favicon.ico는 security 설정에 제외한다.
                .antMatchers(GET, staticResources()).permitAll()
                .antMatchers(GET, "/favicon.ico").permitAll()

                // SpringSecurity 적용 제외 대상을 설정한다.
                .antMatchers(allowedResources())
                .permitAll()

                // SpringSecurity 적용 대상을 설정한다.
                .antMatchers(notAllowedResources())
                .hasAnyAuthority();
    }

    private String[] staticResources() {
        return Stream.of("/static")
                .map(resource -> resource + "/*/**")
                .toArray(String[]::new);
    }

    private String[] notAllowedResources() {
        return Stream.of("/api/**")
                .toArray(String[]::new);
    }

    private String[] allowedResources() {
        return Stream.of()
                .toArray(String[]::new);
    }

}
