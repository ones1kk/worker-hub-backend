package com.breakingbad.workerhub.core.tool;

import io.github.ones1kk.assertion.core.Asserts;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

import static com.breakingbad.workerhub.constant.Patterns.URL_PATTERN;

public final class URIBuilder {

    private final UriComponentsBuilder builder;

    public URIBuilder(String uri) {
        Asserts.that(uri).isNotNull().hasText()
                .as("올바른 URI 형식이 아닙니다. '{}'", uri)
                .matches(URL_PATTERN);
        this.builder = UriComponentsBuilder.fromUriString(uri);
    }

    public URIBuilder param(String key, Object value) {
        builder.queryParam(key, value);
        return this;
    }

    public URIBuilder param(MultiValueMap<String, String> param) {
        builder.queryParams(param);
        return this;
    }

    public URIBuilder addPath(String path) {
        builder.path(path);
        return this;
    }

    public String getURI() {
        return builder.build().toString();
    }

    public String getEncodedURI() {
        return builder.build()
                .encode(StandardCharsets.UTF_8)
                .toString();
    }

}
