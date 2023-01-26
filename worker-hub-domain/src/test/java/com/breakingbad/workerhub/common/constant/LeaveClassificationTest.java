package com.breakingbad.workerhub.common.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeaveClassificationTest {

    @Nested
    @DisplayName("getter 테스트")
    class GetterTest {

        @Test
        @DisplayName("getValue() 테스트")
        void getValue() {
            String code01Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_01.getValue();
            String code02Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_02.getValue();
            String code03Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_03.getValue();
            String code04Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_04.getValue();
            String code05Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_05.getValue();
            String code06Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_06.getValue();
            String code07Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_07.getValue();
            String code08Value = LeaveClassification.LEAVE_CLASSIFICATION_CODE_08.getValue();

            assertThat(code01Value).isEqualTo("PAID_LEAVE");
            assertThat(code02Value).isEqualTo("ANNUAL_LEAVE");
            assertThat(code03Value).isEqualTo("MONTHLY_LEAVE");
            assertThat(code04Value).isEqualTo("SICK_LEAVE");
            assertThat(code05Value).isEqualTo("PERSONAL_LEAVE");
            assertThat(code06Value).isEqualTo("MATERNITY_LEAVE");
            assertThat(code07Value).isEqualTo("MORNING_LEAVE");
            assertThat(code08Value).isEqualTo("AFTERNOON_LEAVE");
        }

        @Test
        @DisplayName("getDescription() 테스트")
        void getDescription() {
            String code01Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_01.getDescription();
            String code02Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_02.getDescription();
            String code03Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_03.getDescription();
            String code04Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_04.getDescription();
            String code05Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_05.getDescription();
            String code06Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_06.getDescription();
            String code07Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_07.getDescription();
            String code08Description = LeaveClassification.LEAVE_CLASSIFICATION_CODE_08.getDescription();

            assertThat(code01Description).isEqualTo("유급 휴가");
            assertThat(code02Description).isEqualTo("연차");
            assertThat(code03Description).isEqualTo("월차");
            assertThat(code04Description).isEqualTo("병가");
            assertThat(code05Description).isEqualTo("개인 휴가");
            assertThat(code06Description).isEqualTo("출산 휴가");
            assertThat(code07Description).isEqualTo("오전 반차");
            assertThat(code08Description).isEqualTo("오후 반차");
        }
    }

}