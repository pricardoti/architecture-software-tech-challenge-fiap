package br.com.delivery.delivery.application.domain.pedido;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.domain.produto.Produto;

import java.math.BigDecimal;
import java.util.List;

public record Pedido(
        String nomeEstabelecimento,
        String dataHoraSolicitacao,
        String dataHoraFinalizacao,
        BigDecimal subtotal,
        BigDecimal descontos,
        BigDecimal taxaEntrega,
        BigDecimal totalPedido,
        Cliente cliente,
        List<Produto> produtos,
        Avaliacao avaliacao/*,
        Pagamento pagamento*/
) {
}
