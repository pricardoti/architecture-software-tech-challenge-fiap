package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.produto.CadastrarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.EditarProdutoPort;
import br.com.delivery.delivery.application.ports.inbound.produto.ExcluirProdutoPort;
import br.com.delivery.delivery.application.ports.outbound.produto.SalvarProdutoPort;
import br.com.delivery.delivery.application.usecases.produto.CadastrarProdutoUseCase;
import br.com.delivery.delivery.application.usecases.produto.ConsultarProdutoUseCase;
import br.com.delivery.delivery.application.usecases.produto.EditarProdutoUseCase;
import br.com.delivery.delivery.application.usecases.produto.ExcluirProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoBeanConfig {

    @Bean
    public CadastrarProdutoPort cadastrarProdutoPort(SalvarProdutoPort salvarProdutoPort) {
        return new CadastrarProdutoUseCase(salvarProdutoPort);
    }

    @Bean
    public EditarProdutoPort editarProdutoPort() {
        return new EditarProdutoUseCase();
    }

    @Bean
    public ConsultarProdutoPort consultarProdutoPort() {
        return new ConsultarProdutoUseCase();
    }

    @Bean
    public ExcluirProdutoPort excluirProdutoPort() {
        return new ExcluirProdutoUseCase();
    }
}
