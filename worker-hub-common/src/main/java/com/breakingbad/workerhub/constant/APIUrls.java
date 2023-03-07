package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum APIUrls {

    KASI_HOLIDAYS("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"),

    TEST_API("https://jsonplaceholder.typicode.com/todos/1");

    private final String requestURL;

}
