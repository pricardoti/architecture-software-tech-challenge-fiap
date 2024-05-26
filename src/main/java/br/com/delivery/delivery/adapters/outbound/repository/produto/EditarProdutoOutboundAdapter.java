package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.EditarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditarProdutoOutboundAdapter implements EditarProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto editar(Produto produto) {
        var produtoEntity = produtoRepository.save(ProdutoEntity.from(produto));
        return produtoEntity.convertToProduto();
    }
}
