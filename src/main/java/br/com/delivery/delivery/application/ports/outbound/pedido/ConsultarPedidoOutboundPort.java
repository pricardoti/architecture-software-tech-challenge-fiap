package br.com.delivery.delivery.application.ports.outbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

import java.util.Collection;

public interface ConsultarPedidoOutboundPort {

    Collection<Pedido> consultar();
}
