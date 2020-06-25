package com.ben.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public class RestCaller {

    public <T> T makeCall(RestTemplateValueObject restTemplateVO, HttpMethod method, Object request,
                          Class<T> responseType)
    {
        ResponseEntity<T> response = exchange(restTemplateVO, method, request, responseType);
        return response != null ? response.getBody() : null;
    }

    private <T> ResponseEntity<T> exchange(RestTemplateValueObject restTemplateVO, HttpMethod method, Object request,
                                           Class<T> responseType)
    {
        RequestEntity<Object> requestEntity = new RequestEntity<>(request, restTemplateVO.getHttpHeaders(), method,
                restTemplateVO.getUriComponentsBuilder().build().encode().toUri());
        return restTemplateVO.getRestTemplate().exchange(requestEntity, responseType);
    }

}
