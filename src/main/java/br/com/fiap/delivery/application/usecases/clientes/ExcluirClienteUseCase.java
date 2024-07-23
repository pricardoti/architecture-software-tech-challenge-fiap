package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;

import java.util.UUID;

public class ExcluirClienteUseCase {

    private final ClienteGateway clienteGateway;

    public ExcluirClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public void executar(UUID codigoCliente) {
        clienteGateway.excluir(codigoCliente);
    }
}
