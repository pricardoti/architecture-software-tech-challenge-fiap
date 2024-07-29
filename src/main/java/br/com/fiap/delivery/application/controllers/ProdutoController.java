package br.com.fiap.delivery.application.controllers;

import br.com.fiap.delivery.application.exception.ProdutoException;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.application.presenters.produto.CadastrarProdutoPresenter;
import br.com.fiap.delivery.application.presenters.produto.ConsultarProdutoPresenter;
import br.com.fiap.delivery.application.usecases.produtos.CadastrarProdutoUseCase;
import br.com.fiap.delivery.application.usecases.produtos.ConsultarProdutoPorCategoriaUseCase;
import br.com.fiap.delivery.application.usecases.produtos.ConsultarProdutoPorCodigoUseCase;
import br.com.fiap.delivery.application.usecases.produtos.ConsultarProdutoUseCase;
import br.com.fiap.delivery.application.usecases.produtos.EditarProdutoUseCase;
import br.com.fiap.delivery.application.usecases.produtos.ExcluirProdutoUseCase;
import br.com.fiap.delivery.domain.produto.CategoriaProduto;
import br.com.fiap.delivery.domain.produto.Produto;

import java.util.Collection;
import java.util.UUID;

public class ProdutoController<P1, P2> {

    private final CadastrarProdutoPresenter<P1> cadastrarProdutoPresenter;
    private final ConsultarProdutoPresenter<P2> consultarProdutoPresenter;

    private final ConsultarProdutoUseCase consultarProdutoUseCase;
    private final ConsultarProdutoPorCategoriaUseCase consultarProdutoPorCategoriaUseCase;
    private final ConsultarProdutoPorCodigoUseCase consultarProdutoPorCodigoUseCase;
    private final CadastrarProdutoUseCase cadastrarProdutoUseCase;
    private final EditarProdutoUseCase editarProdutoUseCase;
    private final ExcluirProdutoUseCase excluirProdutoUseCase;

    public ProdutoController(
            ProdutoGateway produtoGateway,
            CadastrarProdutoPresenter<P1> cadastrarProdutoPresenter,
            ConsultarProdutoPresenter<P2> consultarProdutoPresenter
    ) {
        this.cadastrarProdutoPresenter = cadastrarProdutoPresenter;
        this.consultarProdutoPresenter = consultarProdutoPresenter;
        this.consultarProdutoUseCase = new ConsultarProdutoUseCase(produtoGateway);
        this.consultarProdutoPorCategoriaUseCase = new ConsultarProdutoPorCategoriaUseCase(produtoGateway);
        this.consultarProdutoPorCodigoUseCase = new ConsultarProdutoPorCodigoUseCase(produtoGateway);
        this.cadastrarProdutoUseCase = new CadastrarProdutoUseCase(produtoGateway, consultarProdutoUseCase);
        this.editarProdutoUseCase = new EditarProdutoUseCase(produtoGateway, consultarProdutoUseCase);
        this.excluirProdutoUseCase = new ExcluirProdutoUseCase(produtoGateway, consultarProdutoPorCodigoUseCase);
    }

    public P1 cadastrar(Produto produto) throws ProdutoException {
        var produtoCadastrado = cadastrarProdutoUseCase.executar(produto);
        return cadastrarProdutoPresenter.handler(produtoCadastrado);
    }

    public Collection<P2> consultarPorCategoria(CategoriaProduto categoriaProduto) {
        var produtos = consultarProdutoPorCategoriaUseCase.executar(categoriaProduto);
        return consultarProdutoPresenter.handler(produtos);
    }

    public P2 consultarPorCodigo(UUID codigoProduto) {
        var produto = consultarProdutoPorCodigoUseCase.executar(codigoProduto);
        return consultarProdutoPresenter.handler(produto);
    }

    public void editar(Produto produto) throws ProdutoException {
        editarProdutoUseCase.executar(produto);
    }

    public void excluir(UUID codigoProduto) throws ProdutoException {
        excluirProdutoUseCase.executar(codigoProduto);
    }
}
