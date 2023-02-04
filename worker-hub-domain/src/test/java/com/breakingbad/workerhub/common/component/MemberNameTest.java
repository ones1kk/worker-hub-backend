package com.breakingbad.workerhub.common.component;

import com.breakingbad.workerhub.domain.component.MemberName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MemberNameTest {

    @Nested
    @DisplayName("MemberName 객체 생성 테스트")
    class MemberNameInstanceTest {

        @ParameterizedTest
        @ValueSource(strings = {"김원식", "한용원", "오석", "Jimmy page", "Slash", "Eric clapton"})
        @DisplayName("정상적인 name 포맷은 MemberName 객체를 생성할 수 있다.")
        void create_success(String value) throws Exception {
            assertThatNoException().isThrownBy(() -> new MemberName(value));
        }

        @ParameterizedTest
        @ValueSource(strings = {"김원식한용원오석", "a", "A", "Jimmy page Slash Eric clapton", "", " ",})
        @DisplayName("비정상적인 name 포맷은 MemberName 객체를 생성할 수 없다.")
        void create_fail(String value) throws Exception {
            assertThatThrownBy(() -> new MemberName(value));
        }

    }

    @Nested
    @DisplayName("toString() 테스트")
    class ToStringTest {

        @ParameterizedTest
        @ValueSource(strings = {"김원식", "한용원", "오석", "Jimmy page", "Slash", "Eric clapton"})
        @DisplayName("toString() 호출 시 MemberName 객체의 name 필드 값을 반환한다.")
        void nameToString(String value) throws Exception {
            // given
            MemberName memberName = new MemberName(value);

            // when
            String toString = memberName.toString();

            // then
            assertThat(toString).isNotNull()
                    .isEqualTo(value);
        }
    }

}