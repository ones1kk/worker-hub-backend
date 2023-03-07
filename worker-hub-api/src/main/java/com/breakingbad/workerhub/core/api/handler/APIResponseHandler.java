package com.breakingbad.workerhub.core.api.handler;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface APIResponseHandler<T> {

    T handle() throws JsonProcessingException;

}
