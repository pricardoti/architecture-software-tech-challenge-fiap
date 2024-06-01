package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

import static br.com.delivery.delivery.application.domain.enums.StatusPedido.AGUARDANDO_PAGAMENTO;

@RequiredArgsConstructor
public class EditarPedidoInboundUseCase implements EditarPedidoInboundPort {

    private final EditarPedidoOutboundPort editarPedidoOutboundPort;

    @Override
    public void editar(Pedido pedido, StatusPedido statusPedido) {
        if (AGUARDANDO_PAGAMENTO.equals(pedido.status()))
            throw new IllegalArgumentException("o status do pedido nao pode ser atualizado, por favor realizar o checkout.");

        pedido.status(statusPedido);
        editarPedidoOutboundPort.editar(pedido);
    }
}
