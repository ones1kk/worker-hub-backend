package com.breakingbad.workerhub.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OpenApiInformationTest {

    @Nested
    @DisplayName("getter 테스트")
    class GetterTest {

        @Test
        @DisplayName("getter() 테스트")
        void getter() {
            String titleValue = OpenApiInformation.TITLE.getValue();
            String descriptionValue = OpenApiInformation.DESCRIPTION.getValue();
            String versionValue = OpenApiInformation.VERSION.getValue();
            String contactNameValue = OpenApiInformation.CONTACT_NAME.getValue();
            String contactEmailValue = OpenApiInformation.CONTACT_EMAIL.getValue();

            assertThat(titleValue).isEqualTo("Worker Hub OPEN API");
            assertThat(descriptionValue).isEqualTo("Worker Hub API 명세서입니다.");
            assertThat(versionValue).isEqualTo("v1.0.0");
            assertThat(contactNameValue).isEqualTo("workerhub.official");
            assertThat(contactEmailValue).isEqualTo("workerhub.official@gmail.com");
        }
    }

}