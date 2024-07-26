package br.com.fiap.delivery.application.gateways;

import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;

import java.util.Collection;
import java.util.UUID;

public interface ProdutoGateway {

    Produto cadastrar(Produto produto);

    Produto consultar(Produto produto);

    Collection<Produto> consultarPorCategoria(CategoriaProduto categoriaProduto);

    Produto consultarPorCodigo(UUID codigoProduto);

    void atualizar(Produto produto);

    void excluir(UUID codigoProduto);
}
