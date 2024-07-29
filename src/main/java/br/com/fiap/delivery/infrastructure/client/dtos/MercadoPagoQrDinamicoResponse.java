package br.com.fiap.delivery.infrastructure.client.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MercadoPagoQrDinamicoResponse {

    @JsonProperty("qr_data")
    private String qrData;

    public static MercadoPagoQrDinamicoResponse of(String qrData) {
        return new MercadoPagoQrDinamicoResponse(qrData);
    }
}