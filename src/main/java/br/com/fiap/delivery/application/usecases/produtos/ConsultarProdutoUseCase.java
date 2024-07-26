package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.Produto;

public class ConsultarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ConsultarProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto executar(Produto produto) {
        return produtoGateway.consultar(produto);
    }
}