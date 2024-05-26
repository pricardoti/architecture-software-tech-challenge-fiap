package br.com.delivery.delivery.application.ports.outbound.produto;

import java.util.UUID;

public interface ExcluirProdutoOutboundPort {

    void excluir(UUID codigoProduto);
}
