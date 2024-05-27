package br.com.delivery.delivery.adapters.inbound.cliente.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CadastrarClienteResponse {

    private @NonNull String codigoCliente;

    public static CadastrarClienteResponse from(UUID codigoCliente) {
        return new CadastrarClienteResponse(codigoCliente.toString());
    }
}
