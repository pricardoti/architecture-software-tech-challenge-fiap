package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ConsultarProdutoInboundUseCase implements ConsultarProdutoInboundPort {

    private final ConsultarProdutoOutboundPort consultarProdutoOutboundPort;

    @Override
    public Produto consultar(UUID codigoProduto) {
        return consultarProdutoOutboundPort.consultar(codigoProduto);
    }
}
