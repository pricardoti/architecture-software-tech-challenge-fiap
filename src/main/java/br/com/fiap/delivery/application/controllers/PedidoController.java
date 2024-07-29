package br.com.fiap.delivery.application.controllers;

import br.com.fiap.delivery.application.exception.PedidoException;
import br.com.fiap.delivery.application.gateways.PagamentoGateway;
import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.application.presenters.pedido.CadastrarPedidoPresenter;
import br.com.fiap.delivery.application.presenters.pedido.ConsultarPedidoPresenter;
import br.com.fiap.delivery.application.usecases.pedidos.CadastrarPedidoUseCase;
import br.com.fiap.delivery.application.usecases.pedidos.ConsultarPedidoPorCodigoUseCase;
import br.com.fiap.delivery.application.usecases.pedidos.ConsultarPedidoUseCase;
import br.com.fiap.delivery.application.usecases.pedidos.EditarPedidoUseCase;
import br.com.fiap.delivery.application.usecases.pedidos.RealizarCheckoutPedidoUseCase;
import br.com.fiap.delivery.application.usecases.produtos.ConsultarProdutoPorCodigoUseCase;
import br.com.fiap.delivery.domain.pedido.Pedido;
import br.com.fiap.delivery.domain.pedido.StatusPedido;

import java.util.Collection;
import java.util.UUID;

public class PedidoController<T1, T2> {

    private final CadastrarPedidoPresenter<T1> cadastrarPedidoPresenter;
    private final ConsultarPedidoPresenter<T2> consultarPedidoPresenter;

    private final CadastrarPedidoUseCase cadastrarPedidoUseCase;
    private final ConsultarPedidoUseCase consultarPedidoUseCase;
    private final EditarPedidoUseCase editarPedidoUseCase;
    private final RealizarCheckoutPedidoUseCase realizarCheckoutPedidoUseCase;

    public PedidoController(
            PedidoGateway pedidoGateway,
            ProdutoGateway produtoGateway,
            PagamentoGateway pagamentoGateway,
            CadastrarPedidoPresenter<T1> cadastrarPedidoPresenter,
            ConsultarPedidoPresenter<T2> consultarPedidoPresenter
    ) {
        this.cadastrarPedidoPresenter = cadastrarPedidoPresenter;
        this.consultarPedidoPresenter = consultarPedidoPresenter;

        var consultarProdutoPorCodigoUseCase = new ConsultarProdutoPorCodigoUseCase(produtoGateway);
        this.cadastrarPedidoUseCase = new CadastrarPedidoUseCase(pedidoGateway, consultarProdutoPorCodigoUseCase);
        this.consultarPedidoUseCase = new ConsultarPedidoUseCase(pedidoGateway);

        var consultarPedidoPorCodigoUseCase = new ConsultarPedidoPorCodigoUseCase(pedidoGateway);
        this.editarPedidoUseCase = new EditarPedidoUseCase(pedidoGateway, consultarPedidoPorCodigoUseCase);
        this.realizarCheckoutPedidoUseCase = new RealizarCheckoutPedidoUseCase(pedidoGateway, pagamentoGateway, consultarPedidoPorCodigoUseCase);
    }

    public T1 cadastrar(Pedido pedido) throws PedidoException {
        var pedidoCadastrado = cadastrarPedidoUseCase.executar(pedido);
        return cadastrarPedidoPresenter.handler(pedidoCadastrado);
    }

    public void atualizar(UUID codigoPedido, StatusPedido novoStatus) throws PedidoException {
        editarPedidoUseCase.executar(codigoPedido, novoStatus);
    }

    public void checkout(UUID codigoPedido) throws PedidoException {
        realizarCheckoutPedidoUseCase.executar(codigoPedido);
    }

    public Collection<T2> consultar() {
        var pedidos = consultarPedidoUseCase.executar();
        return consultarPedidoPresenter.handler(pedidos);
    }
}
