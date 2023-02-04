package com.breakingbad.workerhub.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum YesOrNo {

    Y("YES"),

    N("NO");

    private final String value;
}
