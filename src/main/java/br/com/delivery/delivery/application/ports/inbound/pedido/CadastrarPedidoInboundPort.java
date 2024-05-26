package br.com.delivery.delivery.application.ports.inbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

public interface CadastrarPedidoInboundPort {

    Pedido salvar(Pedido pedido);
}
