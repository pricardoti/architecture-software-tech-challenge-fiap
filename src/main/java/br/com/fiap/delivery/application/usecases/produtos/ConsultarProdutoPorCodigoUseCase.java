package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;

import java.util.UUID;

public class ConsultarProdutoPorCodigoUseCase {

    private final ProdutoGateway produtoGateway;

    public ConsultarProdutoPorCodigoUseCase(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public Produto executar(UUID codigoProduto) {
        return produtoGateway.consultarPorCodigo(codigoProduto);
    }
}