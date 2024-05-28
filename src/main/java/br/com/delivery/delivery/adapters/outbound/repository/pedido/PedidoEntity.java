package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.cliente.ClienteEntity;
import br.com.delivery.delivery.adapters.outbound.repository.produto.PedidoProdutoEntity;
import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "pedidos")
@Accessors(fluent = true)
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;

    @Column(name = "codigo_cliente", nullable = false)
    private UUID codigoCliente;

    private BigDecimal valorTotal;
    private StatusPedido status;
    private LocalDateTime dataHoraSolicitacao;

    @ManyToOne
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_cliente", insertable = false, updatable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<PedidoProdutoEntity> produtos;

    public static PedidoEntity createByDomain(Pedido pedido) {
        return PedidoEntity.builder()
                .codigo(pedido.getCodigoPedido())
                .codigoCliente(pedido.getCliente())
                .status(pedido.getStatus())
                .dataHoraSolicitacao(pedido.getDataHoraSolicitacao())
                .valorTotal(pedido.getValorTotal())
                .produtos(
                        pedido.getProdutos()
                                .stream()
                                .map(produto -> PedidoProdutoEntity.createByDomain(pedido.getCodigoPedido(), produto))
                                .toList()
                )
                .build();
    }

    public Pedido toDomain() {
        return Pedido.builder()
                .codigoPedido(codigo)
                .cliente(codigoCliente)
                .valorTotal(valorTotal)
                .status(status)
                .produtos(
                        produtos.stream()
                                .map(PedidoProdutoEntity::toDomain)
                                .toList()
                )
                .dataHoraSolicitacao(dataHoraSolicitacao)
                .build();
    }

}