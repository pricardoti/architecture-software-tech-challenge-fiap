package br.com.fiap.delivery.configuration;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.application.usecases.clientes.CadastrarClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    @Bean
    public <T> CadastrarClienteUseCase cadastrarClienteUseCase(
            ClienteGateway clienteGateway,
             CadastrarClientePresenter<T> cadastrarClientePresenter
    ) {
        return new CadastrarClienteUseCase<T>(clienteGateway, cadastrarClientePresenter);
    }
}
