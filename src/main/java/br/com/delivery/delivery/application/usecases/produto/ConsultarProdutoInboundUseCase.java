package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class ConsultarProdutoInboundUseCase implements ConsultarProdutoInboundPort {

    private final ConsultarProdutoOutboundPort consultarProdutoOutboundPort;

    @Override
    public Collection<Produto> consultar(CategoriaProduto categoria) {
        return consultarProdutoOutboundPort.consultar(categoria);
    }
}
