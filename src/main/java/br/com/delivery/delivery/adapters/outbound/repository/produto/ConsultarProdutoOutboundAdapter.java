package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ConsultarProdutoOutboundAdapter implements ConsultarProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto consultar(UUID codigoProduto) {
        var produtoEntity = produtoRepository.findById(codigoProduto);
        return produtoEntity
                .orElseThrow(IllegalArgumentException::new)
                .convertToProduto();
    }
}
