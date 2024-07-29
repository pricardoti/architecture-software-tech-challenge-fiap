package br.com.fiap.delivery.infrastructure.api.pedidos.dtos;

import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.domain.pedido.PedidoProduto;
import br.com.fiap.delivery.domain.pedido.StatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ConsultarPedidoResponse {

    private UUID codigoPedido;
    private UUID cliente;
    private BigDecimal valorTotal;
    private List<PedidoProduto> produtos;
    private StatusPedido status;
    private LocalDateTime dataHoraSolicitacao;

    public ConsultarPedidoResponse(Pedido pedido) {
        this.codigoPedido = pedido.getCodigoPedido();
        this.cliente = pedido.getCliente();
        this.valorTotal = pedido.getValorTotal();
        this.produtos = pedido.getProdutos();
        this.status = pedido.getStatus();
        this.dataHoraSolicitacao = pedido.getDataHoraSolicitacao();
    }
}