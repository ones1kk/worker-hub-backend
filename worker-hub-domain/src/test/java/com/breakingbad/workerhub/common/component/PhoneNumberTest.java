package com.breakingbad.workerhub.common.component;

import com.breakingbad.workerhub.domain.component.PhoneNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PhoneNumberTest {

    @Nested
    @DisplayName("PhoneNumber 객체 생성 테스트")
    class PhoneNumberInstanceTest {

        @ParameterizedTest
        @ValueSource(strings = {"01012341234", "0321231234", "0212341234"})
        @DisplayName("정상적인 phoneNumber 포맷은 PhoneNumber 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new PhoneNumber(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"010-1234-1234", "032-123-1234", "전화번호", "123456", "", " ", "-", "0"})
        @DisplayName("비정상적인 phoneNumber 포맷은 PhoneNumber 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new PhoneNumber(value));
        }
    }


    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @ParameterizedTest
        @ValueSource(strings = {"01012341234", "0321231234", "0212341234"})
        @DisplayName("toString() 호출 시 PhoneNumber 객체의 phoneNumber 필드 값을 반환한다.")
        void emailToString(String value) throws Exception {
            // given
            PhoneNumber email = new PhoneNumber(value);

            // when
            String toString = email.toString();

            // then
            assertThat(toString).isNotNull()
                    .isEqualTo(value);
        }
    }

}