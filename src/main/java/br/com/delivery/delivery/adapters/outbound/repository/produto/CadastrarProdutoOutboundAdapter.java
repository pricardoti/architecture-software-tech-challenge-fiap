package br.com.delivery.delivery.adapters.outbound.repository.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.SalvarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarProdutoOutboundAdapter implements SalvarProdutoOutboundPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) {
        return null;
    }
}