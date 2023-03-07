package com.breakingbad.workerhub.domain.constant;

import io.github.ones1kk.assertion.core.Asserts;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

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

    private static final Map<String, LeaveClassification> $CODE_LOOKUP = EnumSet.allOf(LeaveClassification.class).stream()
            .collect(collectingAndThen(toMap(it -> it.value, it -> it), Collections::unmodifiableMap));

    public static boolean contains(String value) {
        return $CODE_LOOKUP.containsKey(value);
    }

    public static LeaveClassification from(String value) {
        Asserts.that(contains(value)).as("'LeaveClassification' doesn't contain value of '{}'", value).isTrue();
        return $CODE_LOOKUP.get(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
