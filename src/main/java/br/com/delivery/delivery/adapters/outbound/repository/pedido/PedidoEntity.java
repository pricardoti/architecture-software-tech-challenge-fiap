package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Accessors(fluent = true)
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nomeEstabelecimento;
    private String dataHoraSolicitacao;
    private String dataHoraFinalizacao;
    private BigDecimal subtotal;
    private BigDecimal descontos;
    private BigDecimal taxaEntrega;
    private BigDecimal totalPedido;

    // TODO: mapear value objects
    // private Cliente cliente;
    // private List<Produto> produtos;
    // private Avaliacao avaliacao;
    // private Pagamento pagamento;

    public static PedidoEntity from(Pedido pedido) {
        var pedidoEntity = new PedidoEntity();
        pedidoEntity.nomeEstabelecimento(pedido.nomeEstabelecimento());
        pedidoEntity.dataHoraSolicitacao(pedido.dataHoraSolicitacao());
        pedidoEntity.dataHoraFinalizacao(pedido.dataHoraFinalizacao());
        pedidoEntity.subtotal(pedido.subtotal());
        pedidoEntity.descontos(pedido.descontos());
        pedidoEntity.taxaEntrega(pedido.taxaEntrega());
        pedidoEntity.totalPedido(pedido.totalPedido());

        // TODO: mapear value objects
        // pedidoEntity.cliente(pedido.cliente());
        // pedidoEntity.produtos(pedido.produtos());
        // pedidoEntity.avaliacao(pedido.avaliacao());
        // pedidoEntity.pagamento(pedido.pagamento());

        return pedidoEntity;
    }
}