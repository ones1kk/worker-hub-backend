package com.breakingbad.workerhub.common.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SexTest {

    @Nested
    @DisplayName("getter 테스트")
    class GetterTest {

        @Test
        @DisplayName("getValue() 테스트")
        void getValue() {
            String fValue = Sex.F.getValue();
            String mValue = Sex.M.getValue();
            String eValue = Sex.E.getValue();

            assertThat(fValue).isEqualTo("FEMALE");
            assertThat(mValue).isEqualTo("MALE");
            assertThat(eValue).isEqualTo("ETC");
        }

        @Test
        @DisplayName("getValue() 테스트")
        void getDescription() {
            String fDescription = Sex.F.getDescription();
            String mDescription = Sex.M.getDescription();
            String eDescription = Sex.E.getDescription();

            assertThat(fDescription).isEqualTo("여자");
            assertThat(mDescription).isEqualTo("남자");
            assertThat(eDescription).isEqualTo("기타");
        }
    }

}