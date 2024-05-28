package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPorCodigoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ConsultarPedidoPorCodigoInboundUseCase implements ConsultarPedidoPorCodigoInboundPort {

    private final ConsultarPedidoPorCodigoOutboundPort consultarPedidoPorCodigoOutboundPort;

    @Override
    public Pedido consultar(UUID codigoProduto) {
        return consultarPedidoPorCodigoOutboundPort.consultar(codigoProduto);
    }
}
