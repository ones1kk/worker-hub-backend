package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum APIUrls {

    KASI("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/");

    public static final String KASI_URL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/";

    private final String requestURL;

}
