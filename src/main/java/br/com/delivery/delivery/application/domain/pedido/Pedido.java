package br.com.delivery.delivery.application.domain.pedido;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.domain.produto.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Pedido(
        UUID codigoPedido,
        Cliente cliente,
        String dataHoraSolicitacao,
        BigDecimal totalPedido,
        List<Produto> produtos
) {
}
