package br.com.fiap.delivery.infrastructure.configuration;

import br.com.fiap.delivery.application.gateways.ClienteGateway;
import br.com.fiap.delivery.application.presenters.CadastrarClientePresenter;
import br.com.fiap.delivery.application.presenters.ConsultarClientePresenter;
import br.com.fiap.delivery.application.usecases.clientes.AtualizarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.CadastrarClienteUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientePorCpfUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ConsultarClientesUseCase;
import br.com.fiap.delivery.application.usecases.clientes.ExcluirClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfiguration {

    @Bean
    public <T> ConsultarClientesUseCase consultarClientesUseCase(
            ClienteGateway clienteGateway,
            ConsultarClientePresenter<T> cadastrarClientePresenter
    ) {
        return new ConsultarClientesUseCase(clienteGateway, cadastrarClientePresenter);
    }

    @Bean
    public ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase(ClienteGateway clienteGateway) {
        return new ConsultarClientePorCpfUseCase(clienteGateway);
    }

    @Bean
    public <T> CadastrarClienteUseCase cadastrarClienteUseCase(
            ClienteGateway clienteGateway,
            CadastrarClientePresenter<T> cadastrarClientePresenter,
            ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase
    ) {
        return new CadastrarClienteUseCase<T>(clienteGateway, cadastrarClientePresenter, consultarClientePorCpfUseCase);
    }

    @Bean
    public AtualizarClienteUseCase atualizarClienteUseCase(ClienteGateway clienteGateway, ConsultarClientePorCpfUseCase consultarClientePorCpfUseCase) {
        return new AtualizarClienteUseCase(clienteGateway, consultarClientePorCpfUseCase);
    }

    @Bean
    public ExcluirClienteUseCase excluirClienteUseCase(ClienteGateway clienteGateway) {
        return new ExcluirClienteUseCase(clienteGateway);
    }
}
