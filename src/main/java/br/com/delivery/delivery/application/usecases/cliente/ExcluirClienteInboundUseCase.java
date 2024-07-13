package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ExcluirClienteOutboundPort;

import java.util.UUID;

public class ExcluirClienteInboundUseCase implements ExcluirClienteInboundPort {

    private final ExcluirClienteOutboundPort excluirClienteOutboundPort;

    public ExcluirClienteInboundUseCase(ExcluirClienteOutboundPort excluirClienteOutboundPort) {
        this.excluirClienteOutboundPort = excluirClienteOutboundPort;
    }

    @Override
    public void excluir(UUID codigoCliente) {
        excluirClienteOutboundPort.excluir(codigoCliente);
    }
}
