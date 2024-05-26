package br.com.delivery.delivery.application.ports.inbound.produto;

import java.util.UUID;

public interface ExcluirProdutoInboundPort {

    void excluir(UUID idProduto);
}
