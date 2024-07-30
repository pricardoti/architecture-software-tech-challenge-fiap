package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.domain.cliente.Cliente;

import java.util.UUID;

public class ConsultarClientePorCodigoUseCase {

    private final ClienteGateway clienteGateway;

    public ConsultarClientePorCodigoUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Cliente executar(UUID codigo) {
        return clienteGateway.consultarPorCodigo(codigo);
    }
}
