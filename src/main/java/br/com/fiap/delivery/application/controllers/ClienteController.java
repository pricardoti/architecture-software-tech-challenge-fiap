package br.com.fiap.delivery.application.controllers;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.application.presenters.ConsultarClientePresenter;
import br.com.fiap.delivery.application.usecases.clientes.AtualizarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.CadastrarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientePorCodigoUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientePorCpfUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientesUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ExcluirClienteUseCase;
import br.com.fiap.delivery.domain.cliente.Cliente;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

public class ClienteController<T1, T2> {

    private final CadastrarClientePresenter<T1> cadastrarClientePresenter;
    private final ConsultarClientePresenter<T2> consultarClientePresenter;

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase;
    private final ConsultarClientePorCodigoUseCase consultarClientePorCodigoUseCase;
    private final ConsultarClientesUseCase consultarClientesUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final ExcluirClienteUseCase excluirClienteUseCase;

    public ClienteController(
            ClienteGateway clienteGateway,
            CadastrarClientePresenter<T1> cadastrarClientePresenter,
            ConsultarClientePresenter<T2> consultarClientePresenter
    ) {
        this.cadastrarClientePresenter = cadastrarClientePresenter;
        this.consultarClientePresenter = consultarClientePresenter;
        this.consultarClientePorCpfUseCase = new ConsultarClientePorCpfUseCase(clienteGateway);
        this.consultarClientePorCodigoUseCase = new ConsultarClientePorCodigoUseCase(clienteGateway);
        this.consultarClientesUseCase = new ConsultarClientesUseCase(clienteGateway);
        this.cadastrarClienteUseCase = new CadastrarClienteUseCase(clienteGateway, consultarClientePorCpfUseCase);
        this.atualizarClienteUseCase = new AtualizarClienteUseCase(clienteGateway, consultarClientePorCpfUseCase);
        this.excluirClienteUseCase = new ExcluirClienteUseCase(clienteGateway, consultarClientePorCodigoUseCase);
    }

    public T1 cadastrar(Cliente cliente) throws CadastroUsuarioException {
        var clienteCadastrado = cadastrarClienteUseCase.executar(cliente);
        return cadastrarClientePresenter.handler(clienteCadastrado);
    }

    public Collection<T2> consultar(String cpf) {
        if (nonNull(cpf)) {
            var cliente = consultarClientePorCpfUseCase.executar(cpf);
            return consultarClientePresenter.handler(List.of(cliente));
        }

        var clientes = consultarClientesUseCase.executar();
        return consultarClientePresenter.handler(clientes);
    }

    public void atualizar(Cliente cliente) throws CadastroUsuarioException {
        atualizarClienteUseCase.executar(cliente);
    }

    public void excluir(UUID codigoCliente) throws CadastroUsuarioException {
        excluirClienteUseCase.executar(codigoCliente);
    }
}
