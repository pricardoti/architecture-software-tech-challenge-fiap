package br.com.fiap.delivery.infrastructure.configuration;

import br.com.fiap.delivery.application.controllers.ClienteController;
import br.com.fiap.delivery.application.controllers.ProdutoController;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.gateways.ProdutoGateway;
import br.com.fiap.delivery.application.presenters.clientes.CadastrarClientePresenter;
import br.com.fiap.delivery.application.presenters.clientes.ConsultarClientePresenter;
import br.com.fiap.delivery.application.presenters.produtos.CadastrarProdutoPresenter;
import br.com.fiap.delivery.application.presenters.produtos.ConsultarProdutoPresenter;
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
    public <P1, P2> ProdutoController<P1, P2> produtosController(
            ProdutoGateway produtoGateway,
            CadastrarProdutoPresenter<P1> cadastrarProdutoPresenter,
            ConsultarProdutoPresenter<P2> consultarProdutoPresenter
    ) {
        return new ProdutoController<>(produtoGateway, cadastrarProdutoPresenter, consultarProdutoPresenter);
    }
}
