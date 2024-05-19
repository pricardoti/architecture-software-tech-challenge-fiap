package br.com.delivery.delivery.application.ports.inbound.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;

public interface CadastrarProdutoPort {

    Produto salvar(Produto produto);
}
