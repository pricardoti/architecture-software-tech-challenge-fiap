package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.produto.PedidoProdutoEntity;
import br.com.delivery.delivery.adapters.outbound.repository.produto.PedidoProdutoKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface PedidoProdutoRepository extends CrudRepository<PedidoProdutoEntity, PedidoProdutoKey> {

    Collection<PedidoProdutoEntity> findByCodigoPedido(UUID codigoCliente);
}
