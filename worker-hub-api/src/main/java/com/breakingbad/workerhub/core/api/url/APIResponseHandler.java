package com.breakingbad.workerhub.core.api.url;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface APIResponseHandler<T> {

    T handle() throws JsonProcessingException;

}
