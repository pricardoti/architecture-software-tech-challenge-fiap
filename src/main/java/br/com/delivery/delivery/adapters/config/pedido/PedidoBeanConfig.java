package br.com.delivery.delivery.adapters.config.pedido;

import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ExcluirPedidoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoOutboundPort;
import br.com.delivery.delivery.application.usecases.pedido.CadastrarPedidoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ConsultarPedidoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.EditarPedidoInboundUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ExcluirPedidoInboundUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    public CadastrarPedidoInboundPort cadastrarPedidoPort(SalvarPedidoOutboundPort salvarPedidoOutboundPort) {
        return new CadastrarPedidoInboundUseCase(salvarPedidoOutboundPort);
    }

    @Bean
    public EditarPedidoInboundPort editarPedidoPort() {
        return new EditarPedidoInboundUseCase();
    }

    @Bean
    public ConsultarPedidoInboundPort consultarPedidoPort() {
        return new ConsultarPedidoInboundUseCase();
    }

    @Bean
    public ExcluirPedidoInboundPort excluirPedidoPort() {
        return new ExcluirPedidoInboundUseCase();
    }
}
