package br.com.delivery.delivery.application.ports.inbound.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;

import java.util.Collection;

public interface ConsultarProdutoInboundPort {

    Collection<Produto> consultar(CategoriaProduto categoria);
}
