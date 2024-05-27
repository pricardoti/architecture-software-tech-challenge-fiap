package br.com.delivery.delivery.application.ports.outbound.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;

import java.util.Collection;

public interface ConsultarProdutoOutboundPort {

    Collection<Produto> consultar(CategoriaProduto categoria);
}
