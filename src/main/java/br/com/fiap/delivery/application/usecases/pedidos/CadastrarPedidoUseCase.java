package br.com.fiap.delivery.application.usecases.pedidos;

import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.application.usecases.produtos.ConsultarProdutoPorCodigoUseCase;
import br.com.fiap.delivery.domain.pedido.Pedido;

import java.math.BigDecimal;

public class CadastrarPedidoUseCase {

    private static final int QUANTIDADE_MINIMA = 1;

    private final PedidoGateway pedidoGateway;
    private final ConsultarProdutoPorCodigoUseCase consultarProdutoPorCodigoUseCase;

    public CadastrarPedidoUseCase(
            PedidoGateway pedidoGateway,
            ConsultarProdutoPorCodigoUseCase consultarProdutoPorCodigoUseCase
    ) {
        this.pedidoGateway = pedidoGateway;
        this.consultarProdutoPorCodigoUseCase = consultarProdutoPorCodigoUseCase;
    }

    public Pedido executar(Pedido pedido) throws PedidoException {
        pedido.setValorTotal(calcularValorTotalPedido(pedido));
        return pedidoGateway.cadastrar(pedido);
    }

    private BigDecimal calcularValorTotalPedido(Pedido pedido) throws PedidoException {
        var valorTotal = BigDecimal.ZERO;

        for (var pedidoProduto : pedido.getProdutos()) {

            if (pedidoProduto.getQuantidade() < QUANTIDADE_MINIMA) {
                throw new PedidoException("o produto precisa ter pelo menos uma unidade adicionada ao pedido");
            }

            var produto = consultarProdutoPorCodigoUseCase.executar(pedidoProduto.getCodigoProduto());
            valorTotal = valorTotal.add(produto.getPreco().multiply(BigDecimal.valueOf(pedidoProduto.getQuantidade())));
        }

        return valorTotal;
    }
}