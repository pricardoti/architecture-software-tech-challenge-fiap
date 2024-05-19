package br.com.delivery.delivery.application.ports.inbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

import java.util.UUID;

public interface ConsultarPedidoPort {

    Pedido consultar(UUID idPedido);
}
