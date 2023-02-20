package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Algorithm {

    AES_CBC_PKCS5PADDING("AES/CBC/PKCS5Padding"),

    AES("AES"),

    BASE256("BASE256"),

    HS256("HS256"),

    PBEWithMD5AndDES("PBEWithMD5AndDES");

    private final String value;

}
