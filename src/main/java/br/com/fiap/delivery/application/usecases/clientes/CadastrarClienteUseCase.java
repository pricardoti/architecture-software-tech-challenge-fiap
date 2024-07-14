package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.domain.cliente.Cliente;

public class CadastrarClienteUseCase<T> {

    private final ClienteGateway clienteGateway;
    private final CadastrarClientePresenter<T> cadastrarClientePresenter;

    public CadastrarClienteUseCase(
            ClienteGateway clienteGateway,
            CadastrarClientePresenter cadastrarClientePresenter
    ) {
        this.clienteGateway = clienteGateway;
        this.cadastrarClientePresenter = cadastrarClientePresenter;
    }

    public T cadastrar(Cliente cliente) {
        var clienteCadastrado = clienteGateway.cadastrar(cliente);
        return cadastrarClientePresenter.handle(clienteCadastrado);
    }
}
