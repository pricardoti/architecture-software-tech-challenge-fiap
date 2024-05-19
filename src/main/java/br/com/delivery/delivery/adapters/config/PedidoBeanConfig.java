package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.pedido.CadastrarPedidoPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ConsultarPedidoPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.EditarPedidoPort;
import br.com.delivery.delivery.application.ports.inbound.pedido.ExcluirPedidoPort;
import br.com.delivery.delivery.application.ports.outbound.pedido.SalvarPedidoPort;
import br.com.delivery.delivery.application.usecases.pedido.CadastrarPedidoUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ConsultarPedidoUseCase;
import br.com.delivery.delivery.application.usecases.pedido.EditarPedidoUseCase;
import br.com.delivery.delivery.application.usecases.pedido.ExcluirPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoBeanConfig {

    @Bean
    public CadastrarPedidoPort cadastrarPedidoPort(SalvarPedidoPort salvarPedidoPort) {
        return new CadastrarPedidoUseCase(salvarPedidoPort);
    }

    @Bean
    public EditarPedidoPort editarPedidoPort() {
        return new EditarPedidoUseCase();
    }

    @Bean
    public ConsultarPedidoPort consultarPedidoPort() {
        return new ConsultarPedidoUseCase();
    }

    @Bean
    public ExcluirPedidoPort excluirPedidoPort() {
        return new ExcluirPedidoUseCase();
    }
}
