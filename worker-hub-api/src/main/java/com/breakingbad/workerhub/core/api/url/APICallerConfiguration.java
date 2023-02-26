package com.breakingbad.workerhub.core.api.url;

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
public final class APICallerConfiguration {

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

    public static APICallerConfiguration configure(HttpMethod method, RequestProperties requestProperties) {
        return APICallerConfiguration.builder()
                .method(method)
                .requestProperties(requestProperties)
                .build();
    }

    public static APICallerConfiguration configure(HttpMethod method, RequestProperties requestProperties, Map<String, Object> params) {
        return APICallerConfiguration.builder()
                .method(method)
                .requestProperties(requestProperties)
                .params(params)
                .build();
    }

}
