package br.com.delivery.delivery.application.ports.outbound.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;

import java.util.UUID;

public interface RealizarCheckoutPedidoOutboundPort {

    void checkout(UUID codigoPedido, StatusPedido statusPedido);
}
