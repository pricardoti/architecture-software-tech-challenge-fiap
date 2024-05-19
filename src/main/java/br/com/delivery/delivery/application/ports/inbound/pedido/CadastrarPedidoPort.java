package br.com.delivery.delivery.application.ports.inbound.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;

public interface CadastrarPedidoPort {

    Pedido salvar(Pedido pedido);
}
