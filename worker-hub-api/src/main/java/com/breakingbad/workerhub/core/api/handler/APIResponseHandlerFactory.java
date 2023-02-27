package com.breakingbad.workerhub.core.api.handler;

import com.breakingbad.workerhub.constant.APIUrls;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class APIResponseHandlerFactory {

    private final APIUrls apiUrl;
    private final String json;

    @SuppressWarnings("unchecked")
    public <T> T getResponse(Class<T> valueType) throws JsonProcessingException {
        if (Objects.requireNonNull(apiUrl) == APIUrls.KASI_HOLIDAYS) {
            return (T) new KASIResponseHandler(json).handle();
        }
        return new CommonResponseHandler<>(json, valueType).handle();
    }

}
