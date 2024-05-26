package br.com.delivery.delivery.adapters.inbound.cliente.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "from")
public class CadastrarClienteResponse {

    private @NonNull String idCliente;
}
