package com.breakingbad.workerhub.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LeaveClassification {

    LEAVE_CLASSIFICATION_CODE_01("PAID_LEAVE", "유급 휴가"),

    LEAVE_CLASSIFICATION_CODE_02("ANNUAL_LEAVE", "연차"),

    LEAVE_CLASSIFICATION_CODE_03("MONTHLY_LEAVE", "월차"),

    LEAVE_CLASSIFICATION_CODE_04("SICK_LEAVE", "병가"),

    LEAVE_CLASSIFICATION_CODE_05("PERSONAL_LEAVE", "개인 휴가"),

    LEAVE_CLASSIFICATION_CODE_06("MATERNITY_LEAVE", "출산 휴가"),

    LEAVE_CLASSIFICATION_CODE_07("MORNING_LEAVE", "오전 반차"),

    LEAVE_CLASSIFICATION_CODE_08("AFTERNOON_LEAVE", "오후 반차");

    private final String value;

    private final String description;
}
