package com.breakingbad.workerhub.core.api.url;

import com.breakingbad.workerhub.constant.APIUrls;

public class APICaller {

    private final APIUrls apiUrl;

    private APICaller(APIUrls apiUrl) {
        this.apiUrl = apiUrl;
    }

    public static APICaller of(APIUrls apiUrl) {
        return new APICaller(apiUrl);
    }

    public Caller configure(APICallerConfiguration configuration) {
        return new Caller(apiUrl, configuration);
    }

}
