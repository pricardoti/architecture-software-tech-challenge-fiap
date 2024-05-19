package br.com.delivery.delivery.application.ports.outbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

public interface SalvarPedidoPort {

    Pedido salvar(Pedido pedido);
}
