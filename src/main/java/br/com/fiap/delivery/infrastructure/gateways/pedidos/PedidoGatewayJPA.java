package br.com.fiap.delivery.infrastructure.gateways.pedidos;

import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.domain.pedido.StatusPedido;
import br.com.fiap.delivery.infrastructure.gateways.pedidos.mappers.PedidoEntityMapper;
import br.com.fiap.delivery.infrastructure.persistence.pedidos.PedidoEntity;
import br.com.fiap.delivery.infrastructure.persistence.pedidos.PedidoRepositoryJPA;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PedidoGatewayJPA implements PedidoGateway {

    private static final int FAIL_UPDATE = 0;
    private final PedidoRepositoryJPA pedidoRepositoryJPA;

    @Override
    public Pedido cadastrar(Pedido pedido) {
        var pedidoEntity = salvar(pedido);
        return PedidoEntityMapper.toDomain(pedidoEntity);
    }

    @Override
    public void atualizar(Pedido pedido) {
        salvar(pedido);
    }

    private PedidoEntity salvar(Pedido pedido) {
        var pedidoEntity = PedidoEntityMapper.toEntity(pedido);
        return pedidoRepositoryJPA.save(pedidoEntity);
    }

    @Override
    public Pedido consultar(UUID codigoPedido) {
        return pedidoRepositoryJPA.findById(codigoPedido)
                .map(PedidoEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Collection<Pedido> consultar() {
        return pedidoRepositoryJPA.findAll()
                .stream()
                .map(PedidoEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public boolean checkout(UUID codigoPedido, StatusPedido statusPedido) {
        var result = pedidoRepositoryJPA.updateSituacao(codigoPedido, statusPedido);
        return result != FAIL_UPDATE;
    }
}
