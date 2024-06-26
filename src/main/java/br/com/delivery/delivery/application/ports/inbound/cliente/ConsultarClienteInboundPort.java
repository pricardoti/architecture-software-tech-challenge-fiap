package br.com.delivery.delivery.application.ports.inbound.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;

import java.util.Collection;

public interface ConsultarClienteInboundPort {

    Cliente consultarPorCpf(String cpf);

    Collection<Cliente> consultarClientes();
}
