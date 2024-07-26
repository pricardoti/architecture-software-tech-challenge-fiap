package br.com.fiap.delivery.application.presenters.produtos;

import br.com.fiap.delivery.domain.produto.Produto;

public interface CadastrarProdutoPresenter<T> {

    T handler(Produto produto);
}
