package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.domain.cliente.Cliente;

public class AtualizarClienteUseCase {

    private final ClienteGateway clienteGateway;
    private final ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase;

    public AtualizarClienteUseCase(
            ClienteGateway clienteGateway,
            ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase
    ) {
        this.clienteGateway = clienteGateway;
        this.consultarClientePorCpfUseCase = consultarClientePorCpfUseCase;
    }

    public void executar(Cliente cliente) throws CadastroUsuarioException {
        var clienteConsulta = consultarClientePorCpfUseCase.executar(cliente.getCpf());
        if (clienteConsulta == null)
            throw new CadastroUsuarioException("usuario informado não cadastrado!");
        clienteGateway.atualizar(cliente);
    }
}
