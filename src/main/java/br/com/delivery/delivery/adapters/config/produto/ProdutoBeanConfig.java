package br.com.delivery.delivery.adapters.config.produto;

import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoInboundPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoInboundPort;
import br.com.delivery.delivery.application.ports.outbound.produto.SalvarProdutoOutboundPort;
import br.com.delivery.delivery.application.usecases.produto.CadastrarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.ConsultarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.EditarProdutoInboundUseCase;
import br.com.delivery.delivery.application.usecases.produto.ExcluirProdutoInboundUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    public CadastrarProdutoInboundPort cadastrarProdutoPort(SalvarProdutoOutboundPort salvarProdutoOutboundPort) {
        return new CadastrarProdutoInboundUseCase(salvarProdutoOutboundPort);
    }

    @Bean
    public EditarProdutoInboundPort editarProdutoPort() {
        return new EditarProdutoInboundUseCase();
    }

    @Bean
    public ConsultarProdutoInboundPort consultarProdutoPort() {
        return new ConsultarProdutoInboundUseCase();
    }

    @Bean
    public ExcluirProdutoInboundPort excluirProdutoPort() {
        return new ExcluirProdutoInboundUseCase();
    }
}
