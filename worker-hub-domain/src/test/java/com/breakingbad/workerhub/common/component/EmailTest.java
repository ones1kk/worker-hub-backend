package com.breakingbad.workerhub.common.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class EmailTest {

    @Nested
    @DisplayName("Email 객체 생성 테스트")
    class EmailInstanceTest {

        @ParameterizedTest
        @ValueSource(strings = {"ones1k95@gmail.com", "hyone996@gmail.com", "omega0493@naver.com"})
        @DisplayName("정상적인 email 포맷은 Email 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new Email(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"ones1k95", "hyone996", "omega0493", "123456", "워커허브", "워커허브@gmail.com"})
        @DisplayName("비정상적인 email 포맷은 Email 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception{
            assertThatThrownBy(() -> new Email(value));
        }

    }

    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @ParameterizedTest
        @ValueSource(strings= {"ones1k95@gmail.com", "hyone996@gmail.com", "omega0493@naver.com"})
        @DisplayName("toString() 호출 시 Email 객체의 email 필드 값을 반환한다.")
        void emailToString(String value) throws Exception{
            // given
            Email email = new Email(value);

            // when
            String toString = email.toString();

            // then
            assertThat(toString).isNotNull()
                    .isEqualTo(value);
        }
    }

}