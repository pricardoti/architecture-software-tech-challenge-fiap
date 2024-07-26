package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.exception.ProdutoException;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.domain.produto.Produto;

import static java.util.Objects.isNull;

public class EditarProdutoUseCase {

    private final ProdutoGateway produtoGateway;
    private final ConsultarProdutoUseCase consultarProdutoUseCase;

    public EditarProdutoUseCase(
            ProdutoGateway produtoGateway,
            ConsultarProdutoUseCase consultarProdutoUseCase
    ) {
        this.produtoGateway = produtoGateway;
        this.consultarProdutoUseCase = consultarProdutoUseCase;
    }

    public void executar(Produto produto) throws ProdutoException {
        var produtoCadastrao = consultarProdutoUseCase.executar(produto);

        if (isNull(produtoCadastrao))
            throw new ProdutoException("produto não cadastrado, por favor verifique as informações.");

        produtoGateway.cadastrar(produto);
    }
}