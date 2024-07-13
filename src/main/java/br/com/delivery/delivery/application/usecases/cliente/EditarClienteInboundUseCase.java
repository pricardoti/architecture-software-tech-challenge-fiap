package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.EditarClienteOutboundPort;
import lombok.RequiredArgsConstructor;


public class EditarClienteInboundUseCase implements EditarClienteInboundPort {

    private final EditarClienteOutboundPort editarClienteOutboundPort;

    public EditarClienteInboundUseCase(EditarClienteOutboundPort editarClienteOutboundPort) {
        this.editarClienteOutboundPort = editarClienteOutboundPort;
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return editarClienteOutboundPort.editar(cliente);
    }
}
