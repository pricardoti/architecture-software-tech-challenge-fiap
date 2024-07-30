package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.Produto;

import java.util.Collection;
import java.util.Optional;

public class ConsultarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ConsultarProdutoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Optional<Produto> executar(Produto produto) {
        return produtoGateway.consultar(produto);
    }
}