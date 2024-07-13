package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPorCodigoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.RealizarCheckoutPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.RealizarCheckoutPedidoOutboundPort;

import java.util.UUID;

import static br.com.delivery.delivery.application.domain.enums.StatusPedido.AGUARDANDO_PAGAMENTO;
import static br.com.delivery.delivery.application.domain.enums.StatusPedido.EM_PREPARACAO;

public class RealizarCheckoutPedidoInboundUseCase implements RealizarCheckoutPedidoInboundPort {

    private final ConsultarPedidoPorCodigoInboundPort consultarPedidoPorCodigoInboundPort;
    private final RealizarCheckoutPedidoOutboundPort realizarCheckoutPedidoOutboundPort;

    public RealizarCheckoutPedidoInboundUseCase(ConsultarPedidoPorCodigoInboundPort consultarPedidoPorCodigoInboundPort, RealizarCheckoutPedidoOutboundPort realizarCheckoutPedidoOutboundPort) {
        this.consultarPedidoPorCodigoInboundPort = consultarPedidoPorCodigoInboundPort;
        this.realizarCheckoutPedidoOutboundPort = realizarCheckoutPedidoOutboundPort;
    }

    /**
     * A ideia de realizar o fake checkout para simular a confirmacao do pagamento
     * do pedido, com isso o pedido sai do status AGUARDANDO_PAGAMENTO para EM_PREPARACAO.
     * Este comportamento é o envio para a etapa de confeccao dos produtos selecinados no pedido,
     * que so ocorrem a partir desta confirmacao.
     */
    @Override
    public void checkout(UUID codigoPedido) {
        var pedido = consultarPedidoPorCodigoInboundPort.consultar(codigoPedido);

        if (!AGUARDANDO_PAGAMENTO.equals(pedido.getStatus()))
            throw new IllegalArgumentException("nao foi possivel realizar o checkout do pedido");

        realizarCheckoutPedidoOutboundPort.checkout(codigoPedido, EM_PREPARACAO);
    }
}
