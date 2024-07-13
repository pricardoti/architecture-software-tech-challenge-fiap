package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;

import java.util.UUID;

public class ExcluirProdutoInboundUseCase implements ExcluirProdutoInboundPort {

    private final ExcluirProdutoOutboundPort produtoOutboundPort;

    public ExcluirProdutoInboundUseCase(ExcluirProdutoOutboundPort produtoOutboundPort) {
        this.produtoOutboundPort = produtoOutboundPort;
    }

    @Override
    public void excluir(UUID codigoProduto) {
        produtoOutboundPort.excluir(codigoProduto);
    }
}
