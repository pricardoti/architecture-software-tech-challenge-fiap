package br.com.fiap.delivery.infrastructure.persistence.pedidos;

import br.com.fiap.delivery.domain.pedido.StatusPedido;
import br.com.fiap.delivery.infrastructure.persistence.clientes.entities.ClienteEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

import java.io.Serializable;
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
public class PedidoEntity implements Serializable {

    private static final long serialVersionUID = 3536452036203128498L;

    @Id
    @EqualsAndHashCode.Include
    private UUID codigo;

    @Column(name = "codigo_cliente", nullable = false)
    private UUID codigoCliente;

    private BigDecimal valorTotal;
    private StatusPedido status;
    private LocalDateTime dataHoraSolicitacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_cliente", insertable = false, updatable = false)
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoProdutoEntity> produtos;
}