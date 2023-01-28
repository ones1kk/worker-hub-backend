package com.breakingbad.workerhub.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlgorithmTest {

    @Nested
    @DisplayName("getter 테스트")
    class GetterTest {

        @Test
        @DisplayName("getter() 테스트")
        void getter() throws Exception {
            String aesCbcPkcs5PADDINGValue = Algorithm.AES_CBC_PKCS5PADDING.getValue();
            String hs256Value = Algorithm.HS256.getValue();

            assertThat(aesCbcPkcs5PADDINGValue).isEqualTo("AES/CBC/PKCS5Padding");
            assertThat(hs256Value).isEqualTo("HS256");
        }
    }

}