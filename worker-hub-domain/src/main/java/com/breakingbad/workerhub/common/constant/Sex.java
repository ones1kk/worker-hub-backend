package com.breakingbad.workerhub.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Sex {

    M("Male"),

    F("FeMale");

    private final String value;

}
