package br.com.fiap.delivery.infrastructure.api.produtos.presenters;

import br.com.fiap.delivery.application.presenters.produtos.ConsultarProdutoPresenter;
import br.com.fiap.delivery.domain.produto.Produto;
import br.com.fiap.delivery.infrastructure.api.produtos.dtos.ConsultarProdutoResponse;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ConsultarProdutoRestPresenter implements ConsultarProdutoPresenter<ConsultarProdutoResponse> {

    @Override
    public Collection<ConsultarProdutoResponse> handler(Collection<Produto> produtos) {
        return produtos.stream()
                .map(ConsultarProdutoResponse::new)
                .toList();
    }

    @Override
    public ConsultarProdutoResponse handler(Produto produto) {
        return new ConsultarProdutoResponse(produto);
    }
}