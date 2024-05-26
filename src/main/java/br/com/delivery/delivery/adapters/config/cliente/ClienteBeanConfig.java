package br.com.delivery.delivery.adapters.config.cliente;

import br.com.delivery.delivery.application.ports.inbound.cliente.ClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClientePort;
import br.com.delivery.delivery.application.ports.outbound.cliente.SalvarClientePort;
import br.com.delivery.delivery.application.usecases.cliente.ClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ConsultarClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.EditarClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ExcluirClienteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public ClientePort cadastrarClientePort(SalvarClientePort salvarClientePort) {
        return new ClienteUseCase(salvarClientePort);
    }

    @Bean
    public EditarClientePort editarClientePort() {
        return new EditarClienteUseCase();
    }

    @Bean
    public ConsultarClientePort consultarClientePort() {
        return new ConsultarClienteUseCase();
    }

    @Bean
    public ExcluirClientePort excluirClientePort() {
        return new ExcluirClienteUseCase();
    }
}
