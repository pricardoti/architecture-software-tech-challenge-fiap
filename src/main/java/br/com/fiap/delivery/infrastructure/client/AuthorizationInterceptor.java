package br.com.fiap.delivery.infrastructure.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class AuthorizationInterceptor implements RequestInterceptor {

    private static final String PREFIX_BEARER = "Bearer ";
    private final String apiToken;

    public AuthorizationInterceptor(String apiToken) {
        this.apiToken = apiToken;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(AUTHORIZATION, PREFIX_BEARER + apiToken);
    }
}
