package br.com.delivery.delivery.application.ports.inbound.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;

import java.util.UUID;

public interface ConsultarProdutoPorIdInboundPort {

    Produto consultar(UUID idProduto);
}
