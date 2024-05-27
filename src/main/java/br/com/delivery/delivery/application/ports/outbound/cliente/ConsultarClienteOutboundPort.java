package br.com.delivery.delivery.application.ports.outbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

import java.util.Collection;

public interface ConsultarClienteOutboundPort {

    Cliente consultarPorCpf(String cpf);

    Collection<Cliente> consultarClientes();
}
