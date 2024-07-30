package br.com.fiap.delivery.infrastructure.api.clientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CadastrarClienteResponse {

    private @NonNull String codigoCliente;
}
