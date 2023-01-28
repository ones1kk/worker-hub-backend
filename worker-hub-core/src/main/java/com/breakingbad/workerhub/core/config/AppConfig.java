package com.breakingbad.workerhub.core.config;

import com.breakingbad.workerhub.constant.Profiles;
import com.breakingbad.workerhub.core.crypto.AES256;
import com.breakingbad.workerhub.core.crypto.Crypto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Configuration
public class AppConfig {

    /**
     * <p>'application.yml'에 설정되어 있는 'spring.config.activate.on-profile'속성을</p>
     * <p>{@link Value} annotation을 사용하여 가져오는 것을 지양한다.</p>
     *
     * @param profile local, dev, prd
     * @return {@code Profiles}
     * @see Profiles
     */
    @Bean
    @Primary
    public Profiles activeSpringProfile(@NotBlank @Value("${spring.config.activate.on-profile}") String profile) {
        return Profiles.from(profile);
    }

    /**
     * 양방향 암호화
     *
     * @param key 16자리 문자
     * @return {@code AES256}
     * @see AES256
     */
    @Bean
    @Primary
    public Crypto crypto(@NotBlank @Value("${encryption.key}") String key) {
        return new AES256(key);
    }

    /**
     * 단방향 암호화
     *
     * @return {@code BCryptPasswordEncoder}
     * @see BCryptPasswordEncoder
     */
    @Bean
    @Primary
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
