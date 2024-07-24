package br.com.fiap.delivery.infrastructure.configuration.beans;

import br.com.fiap.delivery.application.controllers.ClienteController;
import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.application.presenters.ConsultarClientePresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    @Bean
    public <T1, T2> ClienteController<T1, T2> clienteController(
            ClienteGateway clienteGateway,
            CadastrarClientePresenter<T1> cadastrarClientePresenter,
            ConsultarClientePresenter<T2> consultarClientePresenter
    ) {
        return new ClienteController<>(clienteGateway, cadastrarClientePresenter, consultarClientePresenter);
    }
}
