package br.com.delivery.delivery.application.ports.outbound.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;

import java.util.UUID;

public interface ConsultarProdutoPorIdOutboundPort {

    Produto consultar(UUID codigoProduto);
}
