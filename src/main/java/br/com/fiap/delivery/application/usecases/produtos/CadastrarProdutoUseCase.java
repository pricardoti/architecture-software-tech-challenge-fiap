package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.exception.ProdutoException;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.Produto;

import static java.util.Objects.nonNull;

public class CadastrarProdutoUseCase {

    private final ProdutoGateway produtoGateway;
    private final ConsultarProdutoUseCase consultarProdutoUseCase;

    public CadastrarProdutoUseCase(
            ProdutoGateway produtoGateway,
            ConsultarProdutoUseCase consultarProdutoUseCase
    ) {
        this.produtoGateway = produtoGateway;
        this.consultarProdutoUseCase = consultarProdutoUseCase;
    }

    public Produto executar(Produto produto) throws ProdutoException {
        var produtoCadastrao = consultarProdutoUseCase.executar(produto);

        if (nonNull(produtoCadastrao))
            throw new ProdutoException("produto já cadastrado, por favor verifique as informações.");

        return produtoGateway.cadastrar(produto);
    }
}