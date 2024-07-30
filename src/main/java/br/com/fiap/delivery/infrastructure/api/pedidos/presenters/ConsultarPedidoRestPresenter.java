package br.com.fiap.delivery.infrastructure.api.pedidos.presenters;

import br.com.fiap.delivery.application.presenters.pedido.ConsultarPedidoPresenter;
import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.infrastructure.api.pedidos.dtos.ConsultarPedidoResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ConsultarPedidoRestPresenter implements ConsultarPedidoPresenter<ConsultarPedidoResponse> {

    @Override
    public Collection<ConsultarPedidoResponse> handler(Collection<Pedido> pedidos) {
        return pedidos.stream()
                .map(ConsultarPedidoResponse::new)
                .toList();
    }
}
