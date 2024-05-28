package br.com.delivery.delivery.application.ports.inbound.pedido;

import java.util.UUID;

public interface RealizarCheckoutPedidoInboundPort {

    void checkout(UUID codigoPedido);
}
