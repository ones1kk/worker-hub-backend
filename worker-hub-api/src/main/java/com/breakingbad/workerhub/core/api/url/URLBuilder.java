package com.breakingbad.workerhub.core.api.url;

import io.github.ones1kk.assertion.core.Asserts;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.breakingbad.workerhub.constant.Patterns.URL_PATTERN;

public final class URLBuilder {

    private final StringBuffer appender;

    public URLBuilder(String url) {
        Asserts.that(url).isNotNull().hasText()
                .as("올바른 URL 형식이 아닙니다. '{}'", url)
                .matches(URL_PATTERN);
        this.appender = new StringBuffer(url);
    }

    public URLBuilder firstParam(String key, String value) {
        appender.append("?").append(URLEncoder.encode(key, StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(value, StandardCharsets.UTF_8));
        return this;
    }

    public URLBuilder param(String key, String value) {
        appender.append("&").append(URLEncoder.encode(key, StandardCharsets.UTF_8)).append("=").append(URLEncoder.encode(value, StandardCharsets.UTF_8));
        return this;
    }

    public URLBuilder addPath(String path) {
        appender.append("/").append(URLEncoder.encode(path, StandardCharsets.UTF_8));
        return this;
    }

    public String getResult() {
        return appender.toString();
    }

}
