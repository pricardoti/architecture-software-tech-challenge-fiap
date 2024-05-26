package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.CadastrarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarProdutoOutboundAdapter implements CadastrarProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        var produtoEntity = produtoRepository.save(ProdutoEntity.from(produto));
        return produtoEntity.toDomain();
    }
}
