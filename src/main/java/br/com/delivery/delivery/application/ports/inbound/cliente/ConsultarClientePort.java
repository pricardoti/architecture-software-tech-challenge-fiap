package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

import java.util.UUID;

public interface ConsultarClientePort {

    Cliente consultar(UUID idCliente);
}
