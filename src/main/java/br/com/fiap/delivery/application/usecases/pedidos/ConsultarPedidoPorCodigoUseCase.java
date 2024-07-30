package br.com.fiap.delivery.application.usecases.pedidos;

import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.domain.pedido.Pedido;

import java.util.UUID;

import static java.util.Objects.isNull;

public class ConsultarPedidoPorCodigoUseCase {

    private final PedidoGateway pedidoGateway;

    public ConsultarPedidoPorCodigoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido executar(UUID codigoPedido) throws PedidoException {
        var pedido = pedidoGateway.consultar(codigoPedido);
        if (isNull(pedido)) {
            throw new PedidoException("não foi possivel encontrar o pedido inforamdo, por favor verifique as informações.");
        }
        return pedido;
    }
}