package br.com.fiap.delivery.infrastructure.configuration;

import br.com.fiap.delivery.application.controllers.ClienteController;
import br.com.fiap.delivery.application.controllers.PedidoController;
import br.com.fiap.delivery.application.controllers.ProdutoController;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.gateways.PedidoGateway;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.application.presenters.cliente.CadastrarClientePresenter;
import br.com.fiap.delivery.application.presenters.cliente.ConsultarClientePresenter;
import br.com.fiap.delivery.application.presenters.pedido.CadastrarPedidoPresenter;
import br.com.fiap.delivery.application.presenters.pedido.ConsultarPedidoPresenter;
import br.com.fiap.delivery.application.presenters.produto.CadastrarProdutoPresenter;
import br.com.fiap.delivery.application.presenters.produto.ConsultarProdutoPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public <P1, P2> ClienteController<P1, P2> clienteController(
            ClienteGateway clienteGateway,
            CadastrarClientePresenter<P1> cadastrarClientePresenter,
            ConsultarClientePresenter<P2> consultarClientePresenter
    ) {
        return new ClienteController<>(clienteGateway, cadastrarClientePresenter, consultarClientePresenter);
    }

    @Bean
    public <P1, P2> ProdutoController<P1, P2> produtoController(
            ProdutoGateway produtoGateway,
            CadastrarProdutoPresenter<P1> cadastrarProdutoPresenter,
            ConsultarProdutoPresenter<P2> consultarProdutoPresenter
    ) {
        return new ProdutoController<>(produtoGateway, cadastrarProdutoPresenter, consultarProdutoPresenter);
    }

    @Bean
    public <P1, P2> PedidoController<P1, P2> pedidoController(
            PedidoGateway pedidoGateway,
            ProdutoGateway produtoGateway,
            CadastrarPedidoPresenter<P1> cadastrarPedidoPresenter,
            ConsultarPedidoPresenter<P2> consultarPedidoPresenter
    ) {
        return new PedidoController<>(pedidoGateway, produtoGateway, cadastrarPedidoPresenter, consultarPedidoPresenter);
    }
}
