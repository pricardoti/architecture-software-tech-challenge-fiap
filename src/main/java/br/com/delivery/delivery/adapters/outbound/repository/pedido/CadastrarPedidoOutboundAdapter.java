package br.com.delivery.delivery.adapters.outbound.repository.pedido;

import br.com.delivery.delivery.adapters.outbound.repository.produto.ProdutoRepository;
import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CadastrarPedidoOutboundAdapter implements CadastrarPedidoOutboundPort {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public Pedido salvar(Pedido pedido) {

        var valorTotal = BigDecimal.ZERO;
        for (var pedidoProduto : pedido.produtos()) {
            var produto = produtoRepository.findById(pedidoProduto.codigoProduto())
                    .orElseThrow(() -> new IllegalArgumentException("produto nao encontrado"));
            valorTotal = valorTotal.add(produto.preco().multiply(BigDecimal.valueOf(pedidoProduto.quantidade())));
        }
        pedido.valorTotal(valorTotal);

        var pedidoEntity = pedidoRepository.save(PedidoEntity.createByDomain(pedido));
        return pedidoEntity.toDomain();
    }
}
