package com.breakingbad.workerhub.core.crypto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class AES256Test {

    @Nested
    @DisplayName("AES256 객체 생성 테스트")
    class CreateTest {

        @ParameterizedTest
        @ValueSource(strings = {"abc123def4564321", "cba123def4564abc"})
        @DisplayName("16자리 키를 주입 받은 객체는 정상적으로 생성이 된다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new AES256(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234567abc", "abcdefg"})
        @DisplayName("16자리가 아닌 키를 주입 받은 객체는 정상적인 생성이 이루어지지 않는다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new AES256(value));
        }
    }

    @Nested
    @DisplayName("AES256 암호화 & 복호화 통합 테스트")
    class IntegrationTest {

        private final Crypto crypto = new AES256(UUID.randomUUID().toString().substring(0, 16));

        @ParameterizedTest
        @ValueSource(strings = {"ones1k95@gmail.com", "hyone996@gmail.com", "omega0493@naver.com"})
        void encrypted(String value) throws Exception {
            String encrypted = crypto.encrypt(value);

            assertThat(encrypted).isNotNull().isBase64();
        }

        @ParameterizedTest
        @ValueSource(strings = {"ones1k95@gmail.com", "hyone996@gmail.com", "omega0493@naver.com"})
        void success(String value) throws Exception {
            // given
            String encrypted = crypto.encrypt(value);

            // when
            String decrypted = crypto.decrypt(encrypted);

            // then
            assertThat(decrypted).isNotNull()
                    .isEqualTo(value);
        }

    }

}