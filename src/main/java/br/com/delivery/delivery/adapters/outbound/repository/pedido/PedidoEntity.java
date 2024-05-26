package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.produto.ProdutoPedidoEntity;
import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long codigo;
    private UUID codigoCliente;
    private BigDecimal totalPedido;
    private StatusPedido statusPedido;
    private LocalDateTime dataHoraCriacao;

    // TODO: ajustar logica de produto
//    List<ProdutoPedidoEntity> produtos;

}