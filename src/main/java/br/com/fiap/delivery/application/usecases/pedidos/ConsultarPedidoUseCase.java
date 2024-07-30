package br.com.fiap.delivery.application.usecases.pedidos;

import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.domain.pedido.Pedido;

import java.util.Collection;

public class ConsultarPedidoUseCase {

    private final PedidoGateway pedidoGateway;

    public ConsultarPedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Collection<Pedido> executar() {
        return pedidoGateway.consultar();
    }
}