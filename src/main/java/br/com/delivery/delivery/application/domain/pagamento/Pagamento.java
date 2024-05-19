package br.com.delivery.delivery.application.domain.pagamento;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.domain.produto.Produto;

import java.util.List;

public record Pagamento(
        String tipoDePagamento
) {
}
