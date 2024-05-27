package br.com.delivery.delivery.application.usecases.cliente;


import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarClienteInboundUseCase implements CadastrarClienteInboundPort {

    private final CadastrarClienteOutboundPort cadastrarClienteOutboundPort;

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return cadastrarClienteOutboundPort.cadastrar(cliente);
    }
}
