package br.com.delivery.delivery.application.ports.inbound.pedido;

import java.util.UUID;

public interface ExcluirPedidoPort {

    void excluir(UUID idPedido);
}
