package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;

import java.util.UUID;

public class ConsultarPedidoInboundUseCase implements ConsultarPedidoInboundPort {
    @Override
    public Pedido consultar(UUID idPedido) {
        return null;
    }
}
