package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.ConsultarClientePresenter;
import br.com.fiap.delivery.infrastructure.controllers.clientes.dtos.ConsultarClienteResponse;

import java.util.Collection;

public class ConsultarClientesUseCase<T> {

    private final ClienteGateway clienteGateway;
    private final ConsultarClientePresenter<ConsultarClienteResponse> consultarClientePresenter;

    public ConsultarClientesUseCase(
            ClienteGateway clienteGateway,
            ConsultarClientePresenter<ConsultarClienteResponse> consultarClientePresenter
    ) {
        this.clienteGateway = clienteGateway;
        this.consultarClientePresenter = consultarClientePresenter;
    }

    public Collection<ConsultarClienteResponse> executar() {
        var clientes = clienteGateway.consultarClientes();
        return consultarClientePresenter.handler(clientes);
    }
}
