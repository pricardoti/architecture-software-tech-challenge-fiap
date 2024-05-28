package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class ConsultarPedidoInboundUseCase implements ConsultarPedidoInboundPort {

    private final ConsultarPedidoOutboundPort consultarPedidoOutboundPort;

    @Override
    public Collection<Pedido> consultar() {
        return consultarPedidoOutboundPort.consultar();
    }
}
