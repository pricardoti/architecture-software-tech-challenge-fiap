package br.com.delivery.delivery.application.domain.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Pedido {

    private UUID codigoPedido;
    private UUID cliente;
    private BigDecimal valorTotal;
    private List<PedidoProduto> produtos;
    private StatusPedido status;
    private LocalDateTime dataHoraSolicitacao;
}
