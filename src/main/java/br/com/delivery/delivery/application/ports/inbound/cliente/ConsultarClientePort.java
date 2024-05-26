package br.com.delivery.delivery.application.ports.inbound.cliente;

import java.util.UUID;

import br.com.delivery.delivery.adapters.inbound.cliente.dto.ClienteResponse;

public interface ConsultarClientePort {

    ClienteResponse consultar(String cpf);
}
