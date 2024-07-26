package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;

import java.util.Collection;

public class ConsultarProdutoPorCategoriaUseCase {

    private final ProdutoGateway produtoGateway;

    public ConsultarProdutoPorCategoriaUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Collection<Produto> executar(CategoriaProduto categoriaProduto) {
        return produtoGateway.consultarPorCategoria(categoriaProduto);
    }
}