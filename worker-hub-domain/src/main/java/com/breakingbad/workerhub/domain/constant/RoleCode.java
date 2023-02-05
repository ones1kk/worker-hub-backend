package com.breakingbad.workerhub.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleCode {

    ROLE_CODE_01("ROLE_CODE_01", ""),

    ROLE_CODE_02("ROLE_CODE_02", ""),

    ROLE_CODE_03("ROLE_CODE_03", "");

    private final String code;

    private final String description;

}
