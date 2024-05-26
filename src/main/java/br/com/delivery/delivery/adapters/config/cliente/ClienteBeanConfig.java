package br.com.delivery.delivery.adapters.config.cliente;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import br.com.delivery.delivery.application.usecases.cliente.CadastrarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ConsultarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.EditarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ExcluirClienteInboundUseCase;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public CadastrarClienteInboundPort cadastrarClientePort(CadastrarClienteOutboundPort cadastrarClienteOutboundPort) {
        return new CadastrarClienteInboundUseCase(cadastrarClienteOutboundPort);
    }

    @Bean
    public EditarClienteInboundPort editarClientePort() {
        return new EditarClienteInboundUseCase();
    }

    @Bean
    public ConsultarClienteInboundPort consultarClientePort(CadastrarClienteOutboundPort cadastrarClienteOutboundPort) {
        return new ConsultarClienteInboundUseCase(cadastrarClienteOutboundPort);
    }

    @Bean
    public ExcluirClienteInboundPort excluirClientePort() {
        return new ExcluirClienteInboundUseCase();
    }
}
