package br.com.fiap.delivery.application.presenters.produto;

import br.com.fiap.delivery.domain.produto.Produto;

public interface CadastrarProdutoPresenter<T> {

    T handler(Produto produto);
}
