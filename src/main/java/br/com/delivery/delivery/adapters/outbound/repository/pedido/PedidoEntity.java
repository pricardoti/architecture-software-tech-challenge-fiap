package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "pedidos")
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;
    private UUID codigoCliente;
    private BigDecimal totalPedido;
    private StatusPedido statusPedido;
    private LocalDateTime dataHoraCriacao;

    // TODO: ajustar logica de produto
//    List<ProdutoPedidoEntity> produtos;

    public static PedidoEntity createByDomain(Pedido pedido) {
        var pedidoEntity = new PedidoEntity();
        return pedidoEntity;
    }

}