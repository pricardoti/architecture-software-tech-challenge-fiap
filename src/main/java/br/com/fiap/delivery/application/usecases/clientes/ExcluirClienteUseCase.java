package br.com.fiap.delivery.application.usecases.clientes;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import br.com.fiap.delivery.application.gateways.ClienteGateway;

import java.util.UUID;

public class ExcluirClienteUseCase {

    private final ClienteGateway clienteGateway;
    private final ConsultarClientePorCodigoUseCase consultarClientePorCodigoUseCase;

    public ExcluirClienteUseCase(
            ClienteGateway clienteGateway,
            ConsultarClientePorCodigoUseCase consultarClientePorCodigoUseCase
    ) {
        this.clienteGateway = clienteGateway;
        this.consultarClientePorCodigoUseCase = consultarClientePorCodigoUseCase;
    }

    public void executar(UUID codigoCliente) throws CadastroUsuarioException {
        var clienteConsulta = consultarClientePorCodigoUseCase.executar(codigoCliente);
        if (clienteConsulta == null)
            throw new CadastroUsuarioException("não foi possivel excluir o usuario");
        clienteGateway.excluir(codigoCliente);
    }
}
