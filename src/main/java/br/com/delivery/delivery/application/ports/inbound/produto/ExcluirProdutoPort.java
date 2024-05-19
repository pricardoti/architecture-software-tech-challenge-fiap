package br.com.delivery.delivery.application.ports.inbound.produto;

import java.util.UUID;

public interface ExcluirProdutoPort {

    void excluir(UUID idProduto);
}
