package br.com.fiap.delivery.infrastructure.api.pedidos.presenters;

import br.com.fiap.delivery.application.presenters.pedido.CadastrarPedidoPresenter;
import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.CadastrarPedidoResponse;
import org.springframework.stereotype.Component;

@Component
public class CadastrarPedidoRestPresenter implements CadastrarPedidoPresenter<CadastrarPedidoResponse> {

    @Override
    public CadastrarPedidoResponse handler(Pedido pedido) {
        return CadastrarPedidoResponse.createByCodigoPedido(pedido.getCodigoPedido());
    }
}
