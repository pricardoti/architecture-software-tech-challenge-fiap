package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditarPedidoInboundUseCase implements EditarPedidoInboundPort {

    private final EditarPedidoOutboundPort editarPedidoOutboundPort;

    @Override
    public void editar(Pedido pedido) {
        editarPedidoOutboundPort.editar(pedido);
    }
}
