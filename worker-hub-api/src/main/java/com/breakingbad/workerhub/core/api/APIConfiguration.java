package com.breakingbad.workerhub.core.api;

import com.breakingbad.workerhub.constant.HttpMethod;
import com.breakingbad.workerhub.constant.RequestProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.net.Authenticator;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@ToString
public final class APIConfiguration {

    private HttpMethod method;

    private RequestProperties requestProperties;

    private Map<String, Object> params;

    private List<String> paths;

    private Authenticator authenticator;

    private Integer connectionTimeout;

    private Boolean doOutput;

    private Integer chunkedStreamingMode;

    private Integer fixedLengthStreamingMode;

    private Boolean allowUserInteraction;

    private Boolean instanceFollowRedirects;

    private Boolean defaultUseCaches;

    private Boolean doInput;

    private Integer ifModifiedSince;

    private Integer readTimeout;

    private Boolean useCaches;

    public static APIConfiguration configure(HttpMethod method, RequestProperties requestProperties) {
        return APIConfiguration.builder()
                .method(method)
                .requestProperties(requestProperties)
                .build();
    }

    public static APIConfiguration configure(HttpMethod method, RequestProperties requestProperties, Map<String, Object> params) {
        return APIConfiguration.builder()
                .method(method)
                .requestProperties(requestProperties)
                .params(params)
                .build();
    }

    public static APIConfiguration configureGET() {
        return APIConfiguration.builder()
                .method(HttpMethod.GET)
                .requestProperties(RequestProperties.JSON)
                .build();
    }

    public static APIConfiguration configureGET(Map<String, Object> params) {
        return APIConfiguration.builder()
                .method(HttpMethod.GET)
                .requestProperties(RequestProperties.JSON)
                .params(params)
                .build();
    }

}
