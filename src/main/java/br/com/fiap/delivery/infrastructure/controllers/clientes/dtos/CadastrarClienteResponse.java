package br.com.fiap.delivery.infrastructure.controllers.clientes.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CadastrarClienteResponse {

    private @NonNull String codigoCliente;
}
