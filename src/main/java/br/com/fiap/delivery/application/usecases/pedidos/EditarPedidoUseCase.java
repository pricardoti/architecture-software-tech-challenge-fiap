package br.com.fiap.delivery.application.usecases.pedidos;

import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.domain.pedido.StatusPedido;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static br.com.fiap.delivery.domain.pedido.StatusPedido.RECEBIDO;
import static br.com.fiap.delivery.domain.pedido.StatusPedido.CANCELADO;
import static br.com.fiap.delivery.domain.pedido.StatusPedido.EM_PREPARACAO;
import static br.com.fiap.delivery.domain.pedido.StatusPedido.FINALIZADO;
import static br.com.fiap.delivery.domain.pedido.StatusPedido.PRONTO_ENTREGA;
import static java.util.Objects.isNull;

public class EditarPedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final ConsultarPedidoPorCodigoUseCase consultarPedidoPorCodigoUseCase;

    private static final Map<StatusPedido, StatusPedido> FLUXO_STATUS_PEDIDO;

    static {
        FLUXO_STATUS_PEDIDO = new HashMap<>();
        FLUXO_STATUS_PEDIDO.put(RECEBIDO, EM_PREPARACAO);
        FLUXO_STATUS_PEDIDO.put(EM_PREPARACAO, PRONTO_ENTREGA);
        FLUXO_STATUS_PEDIDO.put(PRONTO_ENTREGA, FINALIZADO);
    }

    public EditarPedidoUseCase(
            PedidoGateway pedidoGateway,
            ConsultarPedidoPorCodigoUseCase consultarPedidoPorCodigoUseCase
    ) {
        this.pedidoGateway = pedidoGateway;
        this.consultarPedidoPorCodigoUseCase = consultarPedidoPorCodigoUseCase;
    }

    public void executar(UUID codigoPedido, StatusPedido statusPedido) throws PedidoException {
        var pedido = consultarPedidoPorCodigoUseCase.executar(codigoPedido);

        var proximoStatusFluxo = FLUXO_STATUS_PEDIDO.get(pedido.getStatus());
        if ((isNull(proximoStatusFluxo)
                || !proximoStatusFluxo.equals(statusPedido))
                && !CANCELADO.equals(statusPedido))
            throw new PedidoException("não foi possivel atualizar o status do pedido, por favor verifique as informações.");

        pedido.setStatus(statusPedido);
        pedidoGateway.atualizar(pedido);
    }
}