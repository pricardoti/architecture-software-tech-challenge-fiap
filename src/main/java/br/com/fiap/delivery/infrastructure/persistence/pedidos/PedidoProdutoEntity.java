package br.com.fiap.delivery.infrastructure.persistence.pedidos;

import br.com.fiap.delivery.domain.pedido.PedidoProduto;
import br.com.fiap.delivery.infrastructure.persistence.produtos.entities.ProdutoEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

@Data
@Entity
@Table(name = "pedido_produtos")
@Accessors(fluent = true)
@NoArgsConstructor
@IdClass(PedidoProdutoKey.class)
public class PedidoProdutoEntity implements Serializable {

    private static final long serialVersionUID = -5574895519390603246L;

    @Id
    @Column(name = "codigo_pedido", nullable = false)
    private UUID codigoPedido;

    @Id
    @Column(name = "codigo_produto", nullable = false)
    private UUID codigoProduto;

    private Integer quantidade;

    @ManyToOne(fetch = EAGER)
    @MapsId("codigoPedido")
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_pedido", insertable = false, updatable = false)
    private PedidoEntity pedido;

    @ManyToOne(fetch = EAGER)
    @MapsId("codigoProduto")
    @JoinColumn(referencedColumnName = "codigo", name = "codigo_produto", insertable = false, updatable = false)
    private ProdutoEntity produto;

    public PedidoProdutoEntity(UUID codigoPedido, PedidoProduto produto) {
        this.codigoPedido = codigoPedido;
        this.codigoProduto = produto.getCodigoProduto();
        this.quantidade = produto.getQuantidade();
    }

    public static PedidoProdutoEntity createByDomain(UUID codigoPedido, PedidoProduto produto) {
        return new PedidoProdutoEntity(codigoPedido, produto);
    }

    public PedidoProduto toDomain() {
        return new PedidoProduto(codigoProduto, quantidade);
    }
}