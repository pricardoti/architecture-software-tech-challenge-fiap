package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.CadastrarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoPorIdOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.EditarProdutoOutboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;
import br.com.delivery.delivery.application.usecases.produto.CadastrarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.ConsultarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.ConsultarProdutoPorCodigoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.EditarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.ExcluirProdutoInboundUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    public CadastrarProdutoInboundPort cadastrarProdutoPort(CadastrarProdutoOutboundPort cadastrarProdutoOutboundPort) {
        return new CadastrarProdutoInboundUseCase(cadastrarProdutoOutboundPort);
    }

    @Bean
    public EditarProdutoInboundPort editarProdutoPort(EditarProdutoOutboundPort editarProdutoOutboundPort) {
        return new EditarProdutoInboundUseCase(editarProdutoOutboundPort);
    }

    @Bean
    public ConsultarProdutoPorIdInboundPort consultarProdutoPorIdPort(ConsultarProdutoPorIdOutboundPort consultarProdutoPorIdOutboundPort) {
        return new ConsultarProdutoPorCodigoInboundUseCase(consultarProdutoPorIdOutboundPort);
    }

    @Bean
    public ConsultarProdutoInboundPort consultarProdutoPort(ConsultarProdutoOutboundPort consultarProdutoOutboundPort) {
        return new ConsultarProdutoInboundUseCase(consultarProdutoOutboundPort);
    }

    @Bean
    public ExcluirProdutoInboundPort excluirProdutoPort(ExcluirProdutoOutboundPort excluirProdutoOutboundPort) {
        return new ExcluirProdutoInboundUseCase(excluirProdutoOutboundPort);
    }
}
