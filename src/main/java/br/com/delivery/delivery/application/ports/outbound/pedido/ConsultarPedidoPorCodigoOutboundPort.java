package br.com.delivery.delivery.application.ports.outbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

import java.util.UUID;

public interface ConsultarPedidoPorCodigoOutboundPort {

    Pedido consultar(UUID codigoPedido);
}
