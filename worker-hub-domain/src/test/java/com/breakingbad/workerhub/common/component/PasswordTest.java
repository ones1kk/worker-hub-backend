package com.breakingbad.workerhub.common.component;

import com.breakingbad.workerhub.domain.component.Password;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PasswordTest {

    @Nested
    @DisplayName("Password 객체 생성 테스트")
    class PasswordInstanceTest {

        @ParameterizedTest
        @ValueSource(strings = {"abcdefg1!", "qwer123!"})
        @DisplayName("정상적인 password 포맷은 Password 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new Password(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc", "abcdef123", "", " "})
        @DisplayName("비정상적인 password 포맷은 Password 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new Password(value));
        }
    }

    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @ParameterizedTest
        @ValueSource(strings = {"abcdefg1!", "qwer123!"})
        @DisplayName("toString() 호출 시 Password 객체의 password 필드 값을 반환한다.")
        void emailToString(String value) throws Exception {
            // given
            Password password = new Password(value);

            // when
            String toString = password.toString();

            // then
            assertThat(toString).isNotNull()
                    .isEqualTo(value);
        }
    }

}