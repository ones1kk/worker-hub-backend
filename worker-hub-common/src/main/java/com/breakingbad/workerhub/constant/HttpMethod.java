package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum HttpMethod {

    GET("GET"),

    POST("POST"),

    PUT("PUT"),

    DELETE("DELETE"),

    PATCH("PATCH"),

    HEAD("HEAD"),

    OPTIONS("OPTIONS"),

    TRACE("TRACE"),

    CONNECT("CONNECT");

    private final String value;

}
