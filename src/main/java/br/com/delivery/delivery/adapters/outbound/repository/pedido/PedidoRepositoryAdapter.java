package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.application.domain.enums.StatusPedido;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.RealizarCheckoutPedidoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements CadastrarPedidoOutboundPort,
        ConsultarPedidoOutboundPort,
        ConsultarPedidoPorCodigoOutboundPort,
        EditarPedidoOutboundPort,
        RealizarCheckoutPedidoOutboundPort {

    private final PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository
                .save(PedidoEntity.createByDomain(pedido))
                .toDomain();
    }

    @Override
    public Collection<Pedido> consultar() {
        return pedidoRepository.findAll()
                .stream()
                .map(PedidoEntity::toDomain)
                .toList();
    }

    @Override
    public Pedido consultar(UUID codigoPedido) {
        return pedidoRepository.findById(codigoPedido)
                .map(PedidoEntity::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("pedido nao econtrado"));
    }

    @Override
    @Transactional
    public void editar(Pedido pedido) {
        pedidoRepository.save(PedidoEntity.createByDomain(pedido));
    }

    @Transactional
    @Override
    public void checkout(UUID codigoPedido, StatusPedido statusPedido) {
        pedidoRepository.updateSituacao(codigoPedido, statusPedido);
    }


}
