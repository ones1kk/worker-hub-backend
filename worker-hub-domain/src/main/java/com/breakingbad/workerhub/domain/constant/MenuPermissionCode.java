package com.breakingbad.workerhub.domain.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuPermissionCode {

    MENU_PERMISSION_01("MENU_PERMISSION_01", "메뉴 쓰기 권한"),

    MENU_PERMISSION_02("MENU_PERMISSION_02", "메뉴 읽기 권한");

    private final String code;

    private final String description;

}
