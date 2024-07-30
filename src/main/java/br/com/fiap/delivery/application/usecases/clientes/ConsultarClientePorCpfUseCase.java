package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.domain.cliente.Cliente;

public class ConsultarClientePorCpfUseCase {

    private final ClienteGateway clienteGateway;

    public ConsultarClientePorCpfUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente executar(String cpf) {
        return clienteGateway.consultarPorCpf(cpf);
    }
}
