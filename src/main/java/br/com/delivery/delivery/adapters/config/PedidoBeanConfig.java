package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPorCodigoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import br.com.delivery.delivery.application.usecases.pedido.CadastrarPedidoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ConsultarPedidoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ConsultarPedidoPorCodigoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.EditarPedidoInboundUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {
    @Bean
    public CadastrarPedidoInboundPort cadastrarPedidoInboundPort(CadastrarPedidoOutboundPort cadastrarClienteOutboundPort) {
        return new CadastrarPedidoInboundUseCase(cadastrarClienteOutboundPort);
    }

    @Bean
    public EditarPedidoInboundPort editarPedidoInboundPort(EditarPedidoOutboundPort editarPedidoOutboundPort) {
        return new EditarPedidoInboundUseCase(editarPedidoOutboundPort);
    }

    @Bean
    public ConsultarPedidoPorCodigoInboundPort consultarPedidoPorCodigoInboundPort(ConsultarPedidoPorCodigoOutboundPort consultarPedidoPorCodigoOutboundPort) {
        return new ConsultarPedidoPorCodigoInboundUseCase(consultarPedidoPorCodigoOutboundPort);
    }

    @Bean
    public ConsultarPedidoInboundPort consultarPedidoInboundPort(ConsultarPedidoOutboundPort consultarPedidoOutboundPort) {
        return new ConsultarPedidoInboundUseCase(consultarPedidoOutboundPort);
    }
}
