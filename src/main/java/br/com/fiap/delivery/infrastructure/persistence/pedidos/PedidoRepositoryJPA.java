package br.com.fiap.delivery.infrastructure.persistence.pedidos;

import br.com.fiap.delivery.domain.pedido.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, UUID> {

    @Modifying
    @Query("UPDATE PedidoEntity p SET p.status = :statusPedido WHERE p.codigo = :codigoPedido")
    int updateSituacao(
            @Param("codigoPedido") UUID codigoPedido,
            @Param("statusPedido") StatusPedido statusPedido
    );
}