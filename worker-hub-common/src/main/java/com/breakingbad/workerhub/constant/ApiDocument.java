package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiDocument {

    TITLE("Worker Hub OPEN API"),

    DESCRIPTION("Worker Hub API 명세서입니다."),

    VERSION("v1.0.0"),

    CONTACT_NAME("workerhub.official"),

    CONTACT_EMAIL("workerhub.official@gmail.com");

    private final String value;

}
