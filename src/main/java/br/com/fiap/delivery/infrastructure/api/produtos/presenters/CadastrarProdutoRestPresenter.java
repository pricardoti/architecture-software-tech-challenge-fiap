package br.com.fiap.delivery.infrastructure.api.produtos.presenters;

import br.com.fiap.delivery.application.presenters.produtos.CadastrarProdutoPresenter;
import br.com.fiap.delivery.domain.produto.Produto;
import br.com.fiap.delivery.infrastructure.api.produtos.dtos.CadastrarProdutoResponse;
import org.springframework.stereotype.Component;

@Component
public class CadastrarProdutoRestPresenter implements CadastrarProdutoPresenter<CadastrarProdutoResponse> {

    @Override
    public CadastrarProdutoResponse handler(Produto produto) {
        return new CadastrarProdutoResponse(produto.getCodigo().toString());
    }
}
