package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ExcluirProdutoInboundUseCase implements ExcluirProdutoInboundPort {

    private final ExcluirProdutoOutboundPort produtoOutboundPort;

    @Override
    public void excluir(UUID codigoProduto) {
        produtoOutboundPort.excluir(codigoProduto);
    }
}
