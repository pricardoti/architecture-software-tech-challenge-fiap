package br.com.delivery.delivery.application.ports.inbound.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import br.com.delivery.delivery.application.domain.pedido.Pedido;

public interface EditarPedidoInboundPort {

    void editar(Pedido pedido, StatusPedido statusPedido);
}
