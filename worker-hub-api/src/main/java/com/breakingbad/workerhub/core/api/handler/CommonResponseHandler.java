package com.breakingbad.workerhub.core.api.handler;

import com.breakingbad.workerhub.core.parser.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonResponseHandler<T> implements APIResponseHandler<T> {

    private final String json;

    private final Class<T> type;

    @Override
    public T handle() throws JsonProcessingException {
        return JsonParser.toObject(json, type);
    }

}
