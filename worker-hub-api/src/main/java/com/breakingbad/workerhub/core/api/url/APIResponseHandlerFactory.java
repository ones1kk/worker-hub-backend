package com.breakingbad.workerhub.core.api.url;

import com.breakingbad.workerhub.constant.APIUrls;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class APIResponseHandlerFactory {

    private final APIUrls apiUrl;
    private final String json;

    @SuppressWarnings("unchecked")
    public <T> T getResponse(Class<T> valueType) throws JsonProcessingException {
        switch (apiUrl) {
            case KASI_HOLIDAYS: return (T) new KASIResponseHandler(json).handle();
            default: return (T) new Object();
        }
    }

}
