package br.com.delivery.delivery.application.ports.outbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

public interface CadastrarClienteOutboundPort {

    Cliente cadastrar(Cliente cliente);

}
