package br.com.delivery.delivery.application.ports.outbound.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;

public interface CadastrarProdutoOutboundPort {

    Produto cadastrar(Produto produto);
}
