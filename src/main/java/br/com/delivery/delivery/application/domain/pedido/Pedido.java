package br.com.delivery.delivery.application.domain.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter(onMethod = @__(@JsonProperty))
@Setter(onMethod = @__(@JsonProperty))
@Accessors(fluent = true)
@Builder
public class Pedido {

    private UUID codigoPedido;
    private UUID cliente;
    private BigDecimal valorTotal;
    private List<PedidoProduto> produtos;
    private StatusPedido status;
    private LocalDateTime dataHoraSolicitacao;
}
