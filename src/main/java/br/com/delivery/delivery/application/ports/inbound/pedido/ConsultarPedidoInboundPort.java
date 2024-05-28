package br.com.delivery.delivery.application.ports.inbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

import java.util.Collection;

public interface ConsultarPedidoInboundPort {

    Collection<Pedido> consultar();
}
