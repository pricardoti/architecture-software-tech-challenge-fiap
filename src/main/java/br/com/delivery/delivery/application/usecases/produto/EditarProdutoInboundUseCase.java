package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.EditarProdutoOutboundPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditarProdutoInboundUseCase implements EditarProdutoInboundPort {

    private final EditarProdutoOutboundPort editarProdutoOutboundPort;

    @Override
    public Produto editar(Produto produto) {
        return editarProdutoOutboundPort.editar(produto);
    }
}
