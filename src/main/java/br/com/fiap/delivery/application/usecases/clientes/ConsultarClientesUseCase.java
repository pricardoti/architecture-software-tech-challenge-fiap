package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.domain.cliente.Cliente;

import java.util.Collection;

public class ConsultarClientesUseCase {

    private final ClienteGateway clienteGateway;

    public ConsultarClientesUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Collection<Cliente> executar() {
        return clienteGateway.consultarClientes();
    }
}
