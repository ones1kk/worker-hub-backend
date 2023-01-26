package com.breakingbad.workerhub.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sex {

    M("MALE", "남자"),

    F("FEMALE", "여자"),

    E("ETC", "기타");

    private final String value;

    private final String description;

}
