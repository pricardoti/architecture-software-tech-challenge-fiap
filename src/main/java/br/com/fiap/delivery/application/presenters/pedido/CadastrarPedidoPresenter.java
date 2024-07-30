package br.com.fiap.delivery.application.presenters.pedido;

import br.com.fiap.delivery.domain.pedido.Pedido;

public interface CadastrarPedidoPresenter<T> {

    T handler(Pedido cliente);
}
