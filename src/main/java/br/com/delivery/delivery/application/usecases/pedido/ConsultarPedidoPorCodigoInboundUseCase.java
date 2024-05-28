package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPorCodigoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
public class ConsultarPedidoPorCodigoInboundUseCase implements ConsultarPedidoPorCodigoInboundPort {

    private final ConsultarPedidoPorCodigoOutboundPort consultarPedidoPorCodigoOutboundPort;

    @Override
    public Pedido consultar(UUID codigoProduto) {
        var pedido = consultarPedidoPorCodigoOutboundPort.consultar(codigoProduto);
        if (isNull(pedido))
            throw new IllegalArgumentException("pedido nao encontrado");
        return pedido;
    }
}
