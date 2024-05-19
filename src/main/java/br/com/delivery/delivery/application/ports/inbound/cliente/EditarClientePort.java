package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

public interface EditarClientePort {

    Cliente editar(Cliente cliente);
}
