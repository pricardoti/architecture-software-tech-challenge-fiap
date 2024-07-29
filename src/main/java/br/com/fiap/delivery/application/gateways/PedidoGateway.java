package br.com.fiap.delivery.application.gateways;

import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.domain.pedido.StatusPedido;

import java.util.Collection;
import java.util.UUID;

public interface PedidoGateway {

    Pedido cadastrar(Pedido pedido);

    void atualizar(Pedido pedido);

    Pedido consultar(UUID codigoPedido);

    Collection<Pedido> consultar();

    boolean checkout(UUID codigoPedido, StatusPedido statusPedido);
}
