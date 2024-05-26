package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ExcluirProdutoOutboundAdapter implements ExcluirProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public void excluir(UUID codigoProduto) {
        produtoRepository.deleteById(codigoProduto);
    }
}
