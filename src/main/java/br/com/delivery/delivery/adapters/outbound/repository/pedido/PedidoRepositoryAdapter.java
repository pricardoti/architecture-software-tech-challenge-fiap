package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.produto.ProdutoRepository;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements CadastrarPedidoOutboundPort,
        ConsultarPedidoOutboundPort,
        ConsultarPedidoPorCodigoOutboundPort,
        EditarPedidoOutboundPort {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public Pedido salvar(Pedido pedido) {

        var valorTotal = BigDecimal.ZERO;
        for (var pedidoProduto : pedido.getProdutos()) {
            var produto = produtoRepository.findById(pedidoProduto.getCodigoProduto())
                    .orElseThrow(() -> new IllegalArgumentException("produto nao encontrado"));
            valorTotal = valorTotal.add(produto.preco().multiply(BigDecimal.valueOf(pedidoProduto.getQuantidade())));
        }
        pedido.setValorTotal(valorTotal);

        var pedidoEntity = pedidoRepository.save(PedidoEntity.createByDomain(pedido));
        return pedidoEntity.toDomain();
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
    public void editar(Pedido pedido) {
        pedidoRepository.save(PedidoEntity.createByDomain(pedido));
    }
}
