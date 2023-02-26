package com.breakingbad.workerhub.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum APIUrls {

    KASI_HOLIDAYS("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo");

    public static final String KASI_HOLIDAYS_URL = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo";

    private final String requestURL;

}
