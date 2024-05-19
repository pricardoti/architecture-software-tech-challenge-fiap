package br.com.delivery.delivery.adapters.inbound.pedido.response;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Accessors(fluent = true)
public class PedidoResponse {

    private @NonNull String idPedido;
    private @NonNull String nomeEstabelecimento;
    private @NonNull String dataHoraSolicitacao;
    private @NonNull String dataHoraFinalizacao;
    private @NonNull BigDecimal subtotal;
    private @NonNull BigDecimal descontos;
    private @NonNull BigDecimal taxaEntrega;
    private @NonNull BigDecimal totalPedido;
}
