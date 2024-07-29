package br.com.fiap.delivery.application.usecases.pedidos;

import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.application.gateways.PagamentoGateway;
import br.com.fiap.delivery.application.gateways.PedidoGateway;

import java.util.UUID;

import static br.com.fiap.delivery.domain.pedido.StatusPedido.RECEBIDO;

public class RealizarCheckoutPedidoUseCase {

    private final PedidoGateway pedidoGateway;
    private final PagamentoGateway pagamentoGateway;
    private final ConsultarPedidoPorCodigoUseCase consultarPedidoPorCodigoUseCase;

    public RealizarCheckoutPedidoUseCase(
            PedidoGateway pedidoGateway,
            PagamentoGateway pagamentoGateway,
            ConsultarPedidoPorCodigoUseCase consultarPedidoPorCodigoUseCase
    ) {
        this.pedidoGateway = pedidoGateway;
        this.pagamentoGateway = pagamentoGateway;
        this.consultarPedidoPorCodigoUseCase = consultarPedidoPorCodigoUseCase;
    }

    /**
     * A ideia de realizar o fake checkout para simular a confirmacao do pagamento
     * do pedido, com isso o pedido sai do status AGUARDANDO_PAGAMENTO para EM_PREPARACAO.
     * Este comportamento é o envio para a etapa de confeccao dos produtos selecinados no pedido,
     * que so ocorrem a partir desta confirmacao.
     */
    public String executar(UUID codigoPedido) throws PedidoException {
        var pedido = consultarPedidoPorCodigoUseCase.executar(codigoPedido);

        if (!RECEBIDO.equals(pedido.getStatus())) {
            throw new PedidoException("o status atual do pedido não permite realizar o checkout.");
        }

        try {
            return pagamentoGateway.gerarQrDinamico(pedido);
        } catch (Exception e) {
            throw new PedidoException("não foi possivel realizar o checkout do pedido, por favor verifique as informações.", e);
        }
    }
}