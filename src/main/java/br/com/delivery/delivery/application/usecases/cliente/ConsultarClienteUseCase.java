package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;

import java.util.UUID;

public class ConsultarClienteUseCase implements ConsultarClientePort {
    @Override
    public Cliente consultar(UUID idCliente) {
        return null;
    }
}
