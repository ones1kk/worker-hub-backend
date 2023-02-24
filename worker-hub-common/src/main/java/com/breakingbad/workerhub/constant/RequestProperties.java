package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RequestProperties {

    JSON("Content-type", "application/json"),

    PLAIN_TEXT("Content-type", "text/plain"),

    HTML("Content-type", "text/html"),

    XML("Content-type", "text/xml"),

    XSL("Content-type", "text/xsl");

    private final String property;

    private final String value;
}
