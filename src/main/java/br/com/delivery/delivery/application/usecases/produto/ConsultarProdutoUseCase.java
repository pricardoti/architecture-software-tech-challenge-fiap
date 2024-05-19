package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPort;

import java.util.UUID;

public class ConsultarProdutoUseCase implements ConsultarProdutoPort {
    @Override
    public Produto consultar(UUID idProduto) {
        return null;
    }
}
