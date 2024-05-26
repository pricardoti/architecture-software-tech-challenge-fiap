package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;

import java.util.UUID;

public class ConsultarProdutoInboundUseCase implements ConsultarProdutoInboundPort {
    @Override
    public Produto consultar(UUID idProduto) {
        return null;
    }
}
