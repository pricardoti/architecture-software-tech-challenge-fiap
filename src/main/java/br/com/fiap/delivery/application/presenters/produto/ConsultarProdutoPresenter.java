package br.com.fiap.delivery.application.presenters.produto;

import br.com.fiap.delivery.domain.produto.Produto;

import java.util.Collection;

public interface ConsultarProdutoPresenter<T> {

    Collection<T> handler(Collection<Produto> produtos);

    T handler(Produto produto);
}
