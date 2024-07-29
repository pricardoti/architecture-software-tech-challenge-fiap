package br.com.fiap.delivery.infrastructure.client;

import br.com.fiap.delivery.infrastructure.client.dtos.MercadoPagoQrDinamicoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(
        name = "mercadoPagoClient",
        url = "${api.pagamento.mercadopago.url}",
        configuration = MercadoPagoConfig.class
)
public interface MercadoPagoClient {

    @RequestMapping(
            method = POST,
            value = "/instore/orders/qr/seller/collectors/{user-id}/pos/{external-id}/qrs",
            produces = APPLICATION_JSON_VALUE
    )
    MercadoPagoQrDinamicoResponse gerarQrDinamico(
            @PathVariable("user-id") String userId,
            @PathVariable("external-id") String externalId
    );
}
