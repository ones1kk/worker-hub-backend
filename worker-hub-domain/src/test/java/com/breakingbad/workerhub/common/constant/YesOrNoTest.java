package com.breakingbad.workerhub.common.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YesOrNoTest {

    @Nested
    @DisplayName("getter 테스트")
    class GetterTest {

        @Test
        @DisplayName("getValue() 테스트")
        void getValue() {
            String yValue = YesOrNo.Y.getValue();
            String nValue = YesOrNo.N.getValue();

            assertThat(yValue).isEqualTo("YES");
            assertThat(nValue).isEqualTo("NO");
        }
    }

}