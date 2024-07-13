package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

public interface CadastrarClienteInboundPort {

    Cliente cadastrar(Cliente cliente);
}
