package br.com.fiap.delivery.application.usecases.produtos;

import br.com.fiap.delivery.application.exception.ProdutoException;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;

import java.util.UUID;

import static java.util.Objects.isNull;

public class ExcluirProdutoUseCase {

    private final ProdutoGateway produtoGateway;
    private final ConsultarProdutoPorCodigoUseCase consultarProdutoPorCodigoUseCase;

    public ExcluirProdutoUseCase(
            ProdutoGateway produtoGateway,
            ConsultarProdutoPorCodigoUseCase consultarProdutoPorCodigoUseCase
    ) {
        this.produtoGateway = produtoGateway;
        this.consultarProdutoPorCodigoUseCase = consultarProdutoPorCodigoUseCase;
    }

    public void executar(UUID codigoProduto) throws ProdutoException {
        var produtoCadastrao = consultarProdutoPorCodigoUseCase.executar(codigoProduto);

        if (isNull(produtoCadastrao))
            throw new ProdutoException("produto não cadastrado, por favor verifique as informações.");

        produtoGateway.excluir(codigoProduto);
    }
}