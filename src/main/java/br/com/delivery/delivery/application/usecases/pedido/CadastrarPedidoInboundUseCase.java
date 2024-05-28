package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CadastrarPedidoInboundUseCase implements CadastrarPedidoInboundPort {

    private final ConsultarProdutoPorIdInboundPort consultarProdutoPorCodigoInboundUseCase;
    private final CadastrarPedidoOutboundPort cadastrarPedidoOutboundPort;

    @Override
    public Pedido cadastrar(Pedido pedido) {
        pedido.setValorTotal(calcularValorTotalPedido(pedido));
        return cadastrarPedidoOutboundPort.salvar(pedido);
    }

    private BigDecimal calcularValorTotalPedido(Pedido pedido) {
        var valorTotal = BigDecimal.ZERO;
        for (var pedidoProduto : pedido.getProdutos()) {
            var produto = consultarProdutoPorCodigoInboundUseCase.consultar(pedidoProduto.getCodigoProduto());
            valorTotal = valorTotal.add(produto.preco().multiply(BigDecimal.valueOf(pedidoProduto.getQuantidade())));
        }
        return valorTotal;
    }
}
