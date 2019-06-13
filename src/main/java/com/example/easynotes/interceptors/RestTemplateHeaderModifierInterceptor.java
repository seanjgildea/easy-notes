package com.example.easynotes.interceptors;

import com.example.easynotes.bootstrap.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
Gets invoked for every incoming request and it will add a custom header value
 */
@Component
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

    @Autowired
    GlobalProperties globalProperties;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        ClientHttpResponse resp = clientHttpRequestExecution.execute(httpRequest, bytes);
        //resp.getHeaders().add("headerName", globalProperties.getGlobalHeader() ); //cannot find symbol
        return resp;
    }
}
