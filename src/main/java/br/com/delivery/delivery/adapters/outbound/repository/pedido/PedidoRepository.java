package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
