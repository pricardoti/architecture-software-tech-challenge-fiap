package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.produto.*;
import br.com.delivery.delivery.application.ports.outbound.produto.*;
import br.com.delivery.delivery.application.usecases.produto.*;
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
        return new ConsultarProdutoPorIdInboundUseCase(consultarProdutoPorIdOutboundPort);
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
