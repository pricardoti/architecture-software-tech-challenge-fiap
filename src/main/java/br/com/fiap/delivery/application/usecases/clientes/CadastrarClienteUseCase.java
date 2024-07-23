package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.domain.cliente.Cliente;

public class CadastrarClienteUseCase<T> {

    private final ClienteGateway clienteGateway;
    private final CadastrarClientePresenter<T> cadastrarClientePresenter;
    private final ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase;

    public CadastrarClienteUseCase(
            ClienteGateway clienteGateway, CadastrarClientePresenter<T> cadastrarClientePresenter,
            ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase
    ) {
        this.clienteGateway = clienteGateway;
        this.cadastrarClientePresenter = cadastrarClientePresenter;
        this.consultarClientePorCpfUseCase = consultarClientePorCpfUseCase;
    }

    public T executar(Cliente cliente) throws CadastroUsuarioException {
        var clienteConsulta = consultarClientePorCpfUseCase.executar(cliente.getCpf());
        if (clienteConsulta != null)
            throw new CadastroUsuarioException("usuario já cadastrado para o cpf informado!");

        var clienteCadastrado = clienteGateway.cadastrar(cliente);
        return cadastrarClientePresenter.handler(clienteCadastrado);
    }
}
