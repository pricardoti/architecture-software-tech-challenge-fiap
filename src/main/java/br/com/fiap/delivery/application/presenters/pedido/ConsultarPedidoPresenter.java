package br.com.fiap.delivery.application.presenters.pedido;

import br.com.fiap.delivery.domain.pedido.Pedido;

import java.util.Collection;

public interface ConsultarPedidoPresenter<T> {

    Collection<T> handler(Collection<Pedido> pedidos);
}
