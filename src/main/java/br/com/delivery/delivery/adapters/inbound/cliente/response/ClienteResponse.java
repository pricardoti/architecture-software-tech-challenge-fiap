package br.com.delivery.delivery.adapters.inbound.cliente.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class ClienteResponse {

    private @NonNull String idCliente;
    private @NonNull String nome;
    private @NonNull String sobreNome;
}
