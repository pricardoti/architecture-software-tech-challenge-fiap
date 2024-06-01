package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CadastrarPedidoInboundUseCase implements CadastrarPedidoInboundPort {

    private static final int QUANTIDADE_MINIMA = 1;

    private final ConsultarProdutoPorIdInboundPort consultarProdutoPorCodigoInboundUseCase;
    private final CadastrarPedidoOutboundPort cadastrarPedidoOutboundPort;

    @Override
    public Pedido cadastrar(Pedido pedido) {
        pedido.valorTotal(calcularValorTotalPedido(pedido));
        return cadastrarPedidoOutboundPort.salvar(pedido);
    }

    private BigDecimal calcularValorTotalPedido(Pedido pedido) {
        var valorTotal = BigDecimal.ZERO;
        for (var pedidoProduto : pedido.produtos()) {

            if (pedidoProduto.quantidade() < QUANTIDADE_MINIMA)
                throw new IllegalArgumentException("o produto precisa ter pelo menos uma unidade adicionada ao pedido");

            var produto = consultarProdutoPorCodigoInboundUseCase.consultar(pedidoProduto.codigoProduto());
            valorTotal = valorTotal.add(produto.preco().multiply(BigDecimal.valueOf(pedidoProduto.quantidade())));
        }
        return valorTotal;
    }
}
