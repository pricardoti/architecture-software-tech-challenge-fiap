package br.com.delivery.delivery.adapters.config.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.delivery.delivery.application.ports.inbound.cliente.ClientePortIn;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClientePort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClientePort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ClientePortOut;
import br.com.delivery.delivery.application.usecases.cliente.ClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ConsultarClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.EditarClienteUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ExcluirClienteUseCase;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public ClientePortIn cadastrarClientePort(ClientePortOut clientePortOut) {
        return new ClienteUseCase(clientePortOut);
    }

    @Bean
    public EditarClientePort editarClientePort() {
        return new EditarClienteUseCase();
    }

    @Bean
    public ConsultarClientePort consultarClientePort(ClientePortOut clientePortOut) {
        return new ConsultarClienteUseCase(clientePortOut);
    }

    @Bean
    public ExcluirClientePort excluirClientePort() {
        return new ExcluirClienteUseCase();
    }
}
