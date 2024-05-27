package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.cliente.CadastrarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ConsultarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.EditarClienteInboundPort;
import br.com.delivery.delivery.application.ports.inbound.cliente.ExcluirClienteInboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ConsultarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.EditarClienteOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.cliente.ExcluirClienteOutboundPort;
import br.com.delivery.delivery.application.usecases.cliente.CadastrarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ConsultarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.EditarClienteInboundUseCase;
import br.com.delivery.delivery.application.usecases.cliente.ExcluirClienteInboundUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {

    @Bean
    public CadastrarClienteInboundPort cadastrarClientePort(CadastrarClienteOutboundPort cadastrarClienteOutboundPort) {
        return new CadastrarClienteInboundUseCase(cadastrarClienteOutboundPort);
    }

    @Bean
    public EditarClienteInboundPort editarClientePort(EditarClienteOutboundPort editarClienteOutboundPort) {
        return new EditarClienteInboundUseCase(editarClienteOutboundPort);
    }

    @Bean
    public ConsultarClienteInboundPort consultarClientePort(ConsultarClienteOutboundPort consultarClienteOutboundPort) {
        return new ConsultarClienteInboundUseCase(consultarClienteOutboundPort);
    }

    @Bean
    public ExcluirClienteInboundPort excluirClientePort(ExcluirClienteOutboundPort excluirClienteOutboundPort) {
        return new ExcluirClienteInboundUseCase(excluirClienteOutboundPort);
    }
}
