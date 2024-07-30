package br.com.fiap.delivery.infrastructure.gateways.pedidos.mappers;

import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.infrastructure.persistence.pedidos.PedidoEntity;
import br.com.fiap.delivery.infrastructure.persistence.pedidos.PedidoProdutoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PedidoEntityMapper {

    public static PedidoEntity toEntity(Pedido pedido) {
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

    public static Pedido toDomain(PedidoEntity pedidoEntity) {
        var pedido = new Pedido();
        pedido.setCodigoPedido(pedidoEntity.codigo());
        pedido.setCliente(pedidoEntity.codigoCliente());
        pedido.setValorTotal(pedidoEntity.valorTotal());
        pedido.setStatus(pedidoEntity.status());
        pedido.setDataHoraSolicitacao(pedidoEntity.dataHoraSolicitacao());
        pedido.setProdutos(
                pedidoEntity.produtos().stream()
                        .map(PedidoProdutoEntity::toDomain)
                        .toList()
        );
        return pedido;
    }
}
