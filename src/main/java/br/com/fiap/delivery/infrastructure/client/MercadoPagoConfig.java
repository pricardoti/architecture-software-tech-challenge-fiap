package br.com.fiap.delivery.infrastructure.client;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class MercadoPagoConfig {

    private final String apiToken;

    public MercadoPagoConfig(@Value("${api.pagamento.mercadopago.token}") String apiToken) {
        this.apiToken = apiToken;
    }

    @Bean
    public RequestInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor(apiToken);
    }
}
